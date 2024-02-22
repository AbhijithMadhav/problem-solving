package org.am.rate_limiting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FixedWindowTest {

    @Test
    void isRequestAllowed() {
        RateLimiter rateLimiter = new FixedWindow(5000, 3);
        Client user1Client = new Client("user1");
        long baseEpochMilli = 1708583924641L;
        assertTrue(rateLimiter.allowRequest(user1Client, new Timestamp(baseEpochMilli + 1000))); // Window start
        assertTrue(rateLimiter.allowRequest(user1Client, new Timestamp(baseEpochMilli + 5999)));
        assertTrue(rateLimiter.allowRequest(user1Client, new Timestamp(baseEpochMilli + 6000))); // Window End
        assertTrue(rateLimiter.allowRequest(user1Client, new Timestamp(baseEpochMilli + 6001)));// Window start
        assertTrue(rateLimiter.allowRequest(user1Client, new Timestamp(baseEpochMilli + 6002)));
        assertTrue(rateLimiter.allowRequest(user1Client, new Timestamp(baseEpochMilli + 6003)));
        assertFalse(rateLimiter.allowRequest(user1Client, new Timestamp(baseEpochMilli + 7000)));
    }
}