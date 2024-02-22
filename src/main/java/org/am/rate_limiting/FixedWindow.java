package org.am.rate_limiting;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FixedWindow implements RateLimiter {

    private final Map<Client, Window> windowByClientId = new HashMap<>();
    private final int windowSizeMs;
    private final int maxRequests;
    private final Lock lock = new ReentrantLock(true);

    public FixedWindow(int windowSizeMs, int maxRequests) {
        this.windowSizeMs = windowSizeMs;
        this.maxRequests = maxRequests;
    }

    @Override
    public boolean allowRequest(Client client, Timestamp requestTimestamp) {
        try {
            // Since the request is user based don't expect too much contention
            lock.lock();
            return synchronizedCheck(client, requestTimestamp);
        } finally {
            lock.unlock();
        }
    }

    private boolean synchronizedCheck(Client client, Timestamp requestTimestamp) {
        Window window = windowByClientId.get(client);
        if (window == null || requestTimestamp.epochMilli() > window.startTime.epochMilli() + windowSizeMs) {
            window = new Window(requestTimestamp);
            windowByClientId.put(client, window);
        }
        if (window.count + 1 <= maxRequests) {
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
