package org.am.rate_limiting;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SlidingWindow implements RateLimiter {

    private final Map<Client, Window> windowByClientId = new HashMap<>();
    private final int windowSizeMs;
    private final int maxRequests;

    private final Lock lock = new ReentrantLock(true);

    public SlidingWindow(int windowSizeMs, int maxRequests) {
        this.windowSizeMs = windowSizeMs;
        this.maxRequests = maxRequests;
    }

    @Override
    public boolean allowRequest(Client client, Timestamp requestTimestamp) {
        try {
            // Since the request if user based don't expect too much contention
            lock.lock();
            return synchronizedCheck(client, requestTimestamp);
        } finally {
            lock.unlock();
        }
    }

    public boolean synchronizedCheck(Client client, Timestamp requestTimestamp) {
        Window window = windowByClientId.get(client);
        if (window == null || requestTimestamp.epochMilli() > window.startTime.epochMilli() + windowSizeMs) {
            window = new Window(requestTimestamp);
            windowByClientId.put(client, window);
        }
        // Determine available capacity based on how much of the window has passed
        // Allow or disallow based on that capacity
        double proportionOfWindowPassed = (double) (requestTimestamp.epochMilli() - window.startTime.epochMilli()) / windowSizeMs;
        if (window.count + 1 <= Math.round(maxRequests - (maxRequests * proportionOfWindowPassed))) {
            window.count++;
            return true;
        }
        return false;
    }

    private static class Window {
        Timestamp startTime;
        int count;

        public Window(Timestamp timestamp) {
            this.startTime = timestamp;
            count = 0;
        }
    }
}
