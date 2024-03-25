package org.am.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecodeTest {

    @Test
    void numDecodings() {
        assertEquals(1, new Decode().numDecodings("10"));
        assertEquals(2, new Decode().numDecodings("12"));

        assertEquals(2, new Decode().numDecodings("11106"));
        assertEquals(2, new Decode().numDecodings("131064"));
        assertEquals(3, new Decode().numDecodings("226"));
        assertEquals(0, new Decode().numDecodings("06"));

    }
}