package org.am.stack;

import java.util.LinkedList;
import java.util.List;

/**
 * Given an array of integers temperatures represents the daily temperatures,
 * return an array answer such that answer[i] is the number of days you have to wait after the
 * ith day to get a warmer temperature. If there is no future day for which this is possible,
 * keep answer[i] == 0 instead.
 */
public class DailyTemperature {
    public int[] dailyTemperatures(int[] temperatures) {

        TempAndIndex[] tempAndIndices = new TempAndIndex[temperatures.length];
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++)
            tempAndIndices[i] = new TempAndIndex(temperatures[i], i);

        List<TempAndIndex> stack = new LinkedList<>();

        // Crux is to recognize that nDay of a temperature can be calculated only once the later higher temperature is encountered
        // Now usage of a stack to store the temperature follows
        for (int i = 0; i < tempAndIndices.length; i++) {
            while (!stack.isEmpty() && tempAndIndices[i].temp > stack.getFirst().temp) {
                TempAndIndex lower = stack.removeFirst();
                result[lower.index] = i - lower.index;
            }
            stack.addFirst(tempAndIndices[i]);
        }
        // not strictly necessary in the java implementation as result[] is all 0's
        while (!stack.isEmpty())
            result[stack.removeFirst().index] = 0;

        return result;
    }

    private record TempAndIndex(int temp, int index){ }
}
