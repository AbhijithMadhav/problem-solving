package org.am.others;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;


public class FreqStack<T> {

    private final Map<T, Integer> freqByElement = new HashMap<>();

    private final Map<Integer, Deque<T>> elementsByFreq = new HashMap<>();

    private int maxElementCount = Integer.MIN_VALUE;
    public void push(T element) {
        freqByElement.merge(element, 1, (curValue, initialValue) -> curValue + 1);

        Integer freq = freqByElement.get(element);
        maxElementCount = Math.max(maxElementCount, freq);

        Deque<T> stack = elementsByFreq.computeIfAbsent(freq, k -> new ArrayDeque<>());
        stack.push(element);
    }

    public T pop() {
        Deque<T> stack = elementsByFreq.get(maxElementCount);
        if (stack == null) {
            return null;
        }

        T element = null;
        if (!stack.isEmpty()) {
            element = stack.pop();
            freqByElement.computeIfPresent(element, (k, v) -> v == 1 ? null : v - 1);
            if (stack.isEmpty())
                maxElementCount--;
        }
        return element;
    }
}