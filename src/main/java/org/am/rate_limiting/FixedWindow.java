package org.am.rate_limiting;

import java.util.HashMap;
import java.util.Map;

public class FixedWindow {

    private final Map<ClientId, Window> windowByClientId = new HashMap<>();
    private final int windowSizeMs;
    private final int maxRequests;

    public FixedWindow(int windowSizeMs, int maxRequests) {
        this.windowSizeMs = windowSizeMs;
        this.maxRequests = maxRequests;
    }

    public boolean allowRequest(ClientId clientId, Timestamp requestTimestamp) {
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
