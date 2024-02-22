package org.am.rate_limiting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SlidingWindowLogTest {

    @Test
    void allowRequest() {
        RateLimiter rateLimiter = new SlidingWindowLog(5000, 3);
        Client user1Client = new Client("user1");
        long baseEpochMilli = 1708583924641L;
        assertTrue(rateLimiter.allowRequest(user1Client, new Timestamp(baseEpochMilli + 1000)));
        assertTrue(rateLimiter.allowRequest(user1Client, new Timestamp(baseEpochMilli + 3000)));
        assertTrue(rateLimiter.allowRequest(user1Client, new Timestamp(baseEpochMilli + 4000)));
        assertFalse(rateLimiter.allowRequest(user1Client, new Timestamp(baseEpochMilli + 4500)));
        assertFalse(rateLimiter.allowRequest(user1Client, new Timestamp(baseEpochMilli + 4800)));
        assertFalse(rateLimiter.allowRequest(user1Client, new Timestamp(baseEpochMilli + 5000)));
        assertFalse(rateLimiter.allowRequest(user1Client, new Timestamp(baseEpochMilli + 6000)));
        assertTrue(rateLimiter.allowRequest(user1Client, new Timestamp(baseEpochMilli + 8000)));
        assertTrue(rateLimiter.allowRequest(user1Client, new Timestamp(baseEpochMilli + 9000)));
        assertTrue(rateLimiter.allowRequest(user1Client, new Timestamp(baseEpochMilli + 10000)));






    }
}