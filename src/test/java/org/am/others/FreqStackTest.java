package org.am.others;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FreqStackTest {

    @Test
    public void freqTest() {
        FreqStack<Integer> freqStack = new FreqStack<>();
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(4);
        freqStack.push(5);
        assertEquals(5, freqStack.pop());
        assertEquals(7, freqStack.pop());
        assertEquals(5, freqStack.pop());
        assertEquals(4, freqStack.pop());
        assertEquals(7, freqStack.pop());
        assertEquals(5, freqStack.pop());
    }

    @Test
    public void freqTest2() {
        FreqStack<Integer> fs = new FreqStack<>();
        fs.push(4);
        fs.push(0);
        fs.push(9);
        fs.push(3);
        fs.push(4);
        fs.push(2);
        assertEquals(4, fs.pop());
        fs.push(6);
        assertEquals(6, fs.pop());
        fs.push(1);
        assertEquals(1, fs.pop());
        fs.push(4);
        assertEquals(4, fs.pop());
        assertEquals(2, fs.pop());
        assertEquals(3, fs.pop());
        assertEquals(9, fs.pop());
        assertEquals(0, fs.pop());
        assertEquals(4, fs.pop());

    }

    @Test
    public void freqTest3() {
        FreqStack<Integer> fs = new FreqStack<>();
        fs.push(6);
        fs.push(8);
        fs.push(6);
        fs.push(9);
        fs.push(8);
        fs.push(6);
        assertEquals(6, fs.pop());
        fs.push(8);
        assertEquals(8, fs.pop());
        fs.push(9);
        assertEquals(9, fs.pop());
        fs.push(8);
        assertEquals(8, fs.pop());
        fs.push(8);
        assertEquals(8, fs.pop());
        assertEquals(8, fs.pop());
        assertEquals(6, fs.pop());
        assertEquals(9, fs.pop());
        assertEquals(8, fs.pop());
        assertEquals(6, fs.pop());

    }
}