package org.am.dp;

import java.util.*;
import java.util.stream.IntStream;

/**
 * <a href="https://leetcode.com/problems/optimal-account-balancing/description/">...</a>
 * Splitwise settlement
 * <a href="https://www.youtube.com/watch?v=WaUlOC1T07c">...</a>
 */
public class OptimalAccountBalancing {

    // TODO : caching
    int minTransactions(int n, int[][] transactions) {

        int[] balance = new int[n];
        for (int[] transaction : transactions) {
            balance[transaction[0]] += transaction[2];
            balance[transaction[1]] -= transaction[2];
        }
        List<Integer> positives = IntStream.of(balance).boxed().filter(b -> b > 0).toList();
        List<Integer> negatives = Arrays.stream(balance).boxed().filter(b -> b < 0).toList();

        return minTransactions(positives, negatives);
    }

    private int minTransactions(List<Integer> positives, List<Integer> negatives) {
        if (positives.isEmpty() && negatives.isEmpty())
            return 0;

        assert !positives.isEmpty() && !negatives.isEmpty();

        int positive = positives.getFirst(); // NOTE : no need for a for loop for the positives
        int count = Integer.MAX_VALUE;
        for (int i = 0; i < negatives.size(); i++) {
            int negative = negatives.get(i);
            List<Integer> newPositives = new LinkedList<>(positives);
            List<Integer> newNegatives = new LinkedList<>(negatives);
            newPositives.removeFirst();
            newNegatives.remove(i);
            if (positive + negative > 0)
                newPositives.add(positive + negative);
            else if (positive + negative < 0)
                newNegatives.add(positive + negative);
            count = Math.min(count, minTransactions(newPositives, newNegatives));
        }
        return count + 1; // +1 is for the settlement in this call
    }
}
