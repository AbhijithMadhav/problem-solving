package org.am.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReversePolishNotationTest {

    @Test
    void evalRPN() {
        assertEquals(6, new ReversePolishNotation().evalRPN(new String[] {"4","13","5","/","+"}));
    }
}