package org.am.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given an array of integers temperatures represents the daily temperatures,
 * return an array answer such that answer[i] is the number of days you have to wait after the
 * ith day to get a warmer temperature. If there is no future day for which this is possible,
 * keep answer[i] == 0 instead.
 */
public class DailyTemperature {

    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> tempStack = new LinkedList<>();
        Deque<Integer> indexStack = new LinkedList<>();
        int[] answer = new int[temperatures.length];

        // Crux is to recognize that nDay of a temperature can be calculated only once the later higher temperature is encountered
        // Now usage of a stack to store the temperature follows
        for (int i = 0; i < temperatures.length; i++) {
            while (!tempStack.isEmpty() && tempStack.peek() < temperatures[i]) {
                tempStack.pop();
                int index = indexStack.pop();
                answer[index] = i - index;
            }
            tempStack.push(temperatures[i]);
            indexStack.push(i);
        }

        while(!tempStack.isEmpty()) {
            tempStack.pop();
            answer[indexStack.pop()] = 0;
        }

        return answer;
    }
}
