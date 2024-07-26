package org.am.binary.search;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/koko-eating-bananas/">...</a>
 */
public class MinEatingSpeed {

    public int minEatingSpeed(int[] piles, int h) {

        assert piles.length > 0;
        long l = 1;
        long r = Arrays.stream(piles).max().getAsInt();
        long minSpeed = -1;
        while (l <= r) {
            long mid = (l + r) / 2;
            if (canKokoEat(piles, h, mid)) {
                minSpeed = mid;
                r = mid - 1;
            } else
                l = mid + 1;
        }
        return (int) minSpeed;
    }

    private boolean canKokoEat(int[] piles, int h, long eatingSpeed) {
        long requiredHours = 0;
        for (int pile : piles)
            requiredHours +=  pile % eatingSpeed == 0 ? pile / eatingSpeed : pile / eatingSpeed + 1;
        return requiredHours <= h;
    }
}
