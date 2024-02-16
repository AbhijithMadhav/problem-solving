package org.am.sliding.window;

import java.util.LinkedList;
import java.util.List;

/**
 * Find the sum of all k length subarrays
 *
 * Sliding window technique : Fixed window
 */
public class KSum {

    public static Integer[] ksum(int[] array, int k) {
        if (k > array.length)
            throw new IllegalArgumentException(k + " is larger than the size of the array");

        List<Integer> ksumList = new LinkedList<>();
        for (int start = 0, end = start + k - 1;
             start < array.length && end < array.length; start++, end++) {
            if (ksumList.isEmpty())
                ksumList.add(sumOfArray(array, 0, end));
            else
                ksumList.add(ksumList.getLast() + array[end] - array[start - 1]);
        }
        return ksumList.toArray(Integer[]::new);
    }

    private static Integer sumOfArray(int[] array, int start, int end) {
        int sum = 0;
        for (int i = start ; i <= end; i++)
            sum += array[i];
        return sum;
    }
}
