package org.am.rate_limiting;

import org.am.rate_limiting.SlidingWindowLog.Request;
import org.junit.jupiter.api.Test;

import static org.am.rate_limiting.SlidingWindowLog.Timestamp;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SlidingWindowLogTest {

    @Test
    void allowRequest() {
        SlidingWindowLog slidingWindowLog = new SlidingWindowLog(5000, 3);
        Request user1Request = new Request("user1");
        long baseEpochMilli = 1708583924641L;
        assertTrue(slidingWindowLog.allowRequest(user1Request, new Timestamp(baseEpochMilli + 1000)));
        assertTrue(slidingWindowLog.allowRequest(user1Request, new Timestamp(baseEpochMilli + 3000)));
        assertTrue(slidingWindowLog.allowRequest(user1Request, new Timestamp(baseEpochMilli + 4000)));
        assertFalse(slidingWindowLog.allowRequest(user1Request, new Timestamp(baseEpochMilli + 4500)));
        assertFalse(slidingWindowLog.allowRequest(user1Request, new Timestamp(baseEpochMilli + 4800)));
        assertFalse(slidingWindowLog.allowRequest(user1Request, new Timestamp(baseEpochMilli + 5000)));
        assertFalse(slidingWindowLog.allowRequest(user1Request, new Timestamp(baseEpochMilli + 6000)));
        assertTrue(slidingWindowLog.allowRequest(user1Request, new Timestamp(baseEpochMilli + 8000)));
        assertTrue(slidingWindowLog.allowRequest(user1Request, new Timestamp(baseEpochMilli + 9000)));
        assertTrue(slidingWindowLog.allowRequest(user1Request, new Timestamp(baseEpochMilli + 10000)));






    }
}