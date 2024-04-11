package org.am.stack;

import java.util.LinkedList;
import java.util.List;

public class MinStack {

    private record Pair(int val, int minUntilNow){}
    private final List<Pair> stack = new LinkedList<>();

    // Crux is to recognize that a stack enables remembering 'min seen until now'
    public void push(int val) {
        int min = val;
        if (!stack.isEmpty())
            min = Math.min(getMin(), min);
        stack.addFirst(new Pair(val, min));
    }

    public void pop() {
        stack.removeFirst();
    }

    public int top() {
        return stack.getFirst().val;
    }

    public int getMin() {
        return stack.getFirst().minUntilNow;
    }
}
