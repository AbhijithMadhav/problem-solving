package org.am.rate_limiting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FixedWindowTest {

    @Test
    void isRequestAllowed() {
        FixedWindow fixedWindow = new FixedWindow(5000, 3);
        ClientId user1ClientId = new ClientId("user1");
        long baseEpochMilli = 1708583924641L;
        assertTrue(fixedWindow.allowRequest(user1ClientId, new Timestamp(baseEpochMilli + 1000))); // Window start
        assertTrue(fixedWindow.allowRequest(user1ClientId, new Timestamp(baseEpochMilli + 5999)));
        assertTrue(fixedWindow.allowRequest(user1ClientId, new Timestamp(baseEpochMilli + 6000))); // Window End
        assertTrue(fixedWindow.allowRequest(user1ClientId, new Timestamp(baseEpochMilli + 6001)));// Window start
        assertTrue(fixedWindow.allowRequest(user1ClientId, new Timestamp(baseEpochMilli + 6002)));
        assertTrue(fixedWindow.allowRequest(user1ClientId, new Timestamp(baseEpochMilli + 6003)));
        assertFalse(fixedWindow.allowRequest(user1ClientId, new Timestamp(baseEpochMilli + 7000)));
    }
}