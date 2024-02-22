package org.am.rate_limiting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FixedWindowTest {

    @Test
    void isRequestAllowed() {
        FixedWindow slidingWindowLog = new FixedWindow(5000, 3);
        ClientId user1ClientId = new ClientId("user1");
        long baseEpochMilli = 1708583924641L;
        assertTrue(slidingWindowLog.allowRequest(user1ClientId, new Timestamp(baseEpochMilli + 1000)));
        assertTrue(slidingWindowLog.allowRequest(user1ClientId, new Timestamp(baseEpochMilli + 3000)));
        assertTrue(slidingWindowLog.allowRequest(user1ClientId, new Timestamp(baseEpochMilli + 4000)));
        assertFalse(slidingWindowLog.allowRequest(user1ClientId, new Timestamp(baseEpochMilli + 4500)));
        assertFalse(slidingWindowLog.allowRequest(user1ClientId, new Timestamp(baseEpochMilli + 4800)));
        assertFalse(slidingWindowLog.allowRequest(user1ClientId, new Timestamp(baseEpochMilli + 5000)));
        assertFalse(slidingWindowLog.allowRequest(user1ClientId, new Timestamp(baseEpochMilli + 6000)));
        assertTrue(slidingWindowLog.allowRequest(user1ClientId, new Timestamp(baseEpochMilli + 7000)));
        assertTrue(slidingWindowLog.allowRequest(user1ClientId, new Timestamp(baseEpochMilli + 8000)));
        assertTrue(slidingWindowLog.allowRequest(user1ClientId, new Timestamp(baseEpochMilli + 9000)));
        assertFalse(slidingWindowLog.allowRequest(user1ClientId, new Timestamp(baseEpochMilli + 10000)));
    }
}