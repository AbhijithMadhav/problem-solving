package org.am.others;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EncodeDecodeTest {

    @Test
    void encodeDecode() {
        EncodeDecode encodeDecode = new EncodeDecode();
        List<String> strs = List.of("leet", "code");
        assertEquals(strs, encodeDecode.decode(encodeDecode.encode(strs)));
        strs = List.of("4#le56#et", "10#co##de");
        assertEquals(strs, encodeDecode.decode(encodeDecode.encode(strs)));
        strs = Collections.emptyList();
        assertEquals(strs, encodeDecode.decode(encodeDecode.encode(strs)));
    }
}