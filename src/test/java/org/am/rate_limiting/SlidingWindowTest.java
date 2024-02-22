package org.am.rate_limiting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SlidingWindowTest {

    @Test
    void isRequestAllowed() {
        SlidingWindow slidingWindow = new SlidingWindow(5000, 3);
        ClientId user1ClientId = new ClientId("user1");
        long baseEpochMilli = 1708583924641L;
        assertTrue(slidingWindow.allowRequest(user1ClientId, new Timestamp(baseEpochMilli + 1000)));
        assertTrue(slidingWindow.allowRequest(user1ClientId, new Timestamp(baseEpochMilli + 3000)));
        assertFalse(slidingWindow.allowRequest(user1ClientId, new Timestamp(baseEpochMilli + 4000)));
        assertFalse(slidingWindow.allowRequest(user1ClientId, new Timestamp(baseEpochMilli + 4500)));
        assertFalse(slidingWindow.allowRequest(user1ClientId, new Timestamp(baseEpochMilli + 4800)));
        assertFalse(slidingWindow.allowRequest(user1ClientId, new Timestamp(baseEpochMilli + 5000)));
        assertFalse(slidingWindow.allowRequest(user1ClientId, new Timestamp(baseEpochMilli + 6000)));
        assertTrue(slidingWindow.allowRequest(user1ClientId, new Timestamp(baseEpochMilli + 7000)));
        assertTrue(slidingWindow.allowRequest(user1ClientId, new Timestamp(baseEpochMilli + 8000)));
        assertFalse(slidingWindow.allowRequest(user1ClientId, new Timestamp(baseEpochMilli + 9000)));
        assertFalse(slidingWindow.allowRequest(user1ClientId, new Timestamp(baseEpochMilli + 10000)));
    }

}