package org.am.rate_limiting;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FixedWindow {

    private final Map<ClientId, Window> windowByClientId = new HashMap<>();
    private final int windowSizeMs;
    private final int maxRequests;
    private final Lock lock = new ReentrantLock(true);

    public FixedWindow(int windowSizeMs, int maxRequests) {
        this.windowSizeMs = windowSizeMs;
        this.maxRequests = maxRequests;
    }

    public boolean allowRequest(ClientId clientId, Timestamp requestTimestamp) {
        try {
            // Since the request if user based don't expect too much contention
            lock.lock();
            return synchronizedCheck(clientId, requestTimestamp);
        } finally {
            lock.unlock();
        }
    }

    private boolean synchronizedCheck(ClientId clientId, Timestamp requestTimestamp) {
        Window window = windowByClientId.get(clientId);
        if (window == null || requestTimestamp.epochMilli() > window.startTime.epochMilli() + windowSizeMs) {
            window = new Window(requestTimestamp);
            windowByClientId.put(clientId, window);
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
