package org.am.rate_limiting;

import java.util.HashMap;
import java.util.Map;

public class SlidingWindow {

    private final Map<ClientId, Window> windowByClientId = new HashMap<>();
    private final int windowSizeMs;
    private final int maxRequests;

    public SlidingWindow(int windowSizeMs, int maxRequests) {
        this.windowSizeMs = windowSizeMs;
        this.maxRequests = maxRequests;
    }

    public boolean allowRequest(ClientId clientId, Timestamp requestTimestamp) {
        Window window = windowByClientId.get(clientId);
        if (window == null || requestTimestamp.epochMilli() > window.startTime.epochMilli() + windowSizeMs) {
            window = new Window(requestTimestamp);
            windowByClientId.put(clientId, window);
        }
        // Determine available capacity based on how much of the window has passed
        // Now
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
