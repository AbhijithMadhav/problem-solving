package org.am.greedy;

import java.util.Arrays;

/**
 * There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station
 * to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.
 * Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique
 */
public class Gas {

    // Crux is to recognise that a position can become start if gas is left
    // TODO
    public int canCompleteCircuit(int[] gas, int[] cost) {

        if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum())
            return -1;

        int start = 0;
        int gasLeft = 0;
        // Evaluate the start for every position
        for (int i = 0; i < gas.length; i++) {
            gasLeft += gas[i] - cost[i];
            if (gasLeft < 0) {
                gasLeft = 0;
                start = i + 1;
            }
        }

        return start;
    }
}
