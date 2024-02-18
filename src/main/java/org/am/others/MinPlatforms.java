package org.am.others;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MinPlatforms {

     record ArrDepTimes(int a, int d) {

    }
    public int minPlatforms(int[] a, int[] d) {
        ArrDepTimes[] times = sort(a, d);
        int minPlatforms = Integer.MIN_VALUE;
        int curPlatforms = 0;
        for (int i = 0, j = 0; i < a.length & j < d.length;) {
            if (times[i].a < times[j].d) {
                curPlatforms++;
                i++;
            } else {
                curPlatforms--;
                j++;
            }
            minPlatforms = Math.max(minPlatforms, curPlatforms);
        }
        return minPlatforms;
    }

    private ArrDepTimes[] sort(int[] a, int[] d) {
         List<ArrDepTimes> arrDepTimes = new LinkedList<>();
         for (int i = 0; i < a.length; i++) {
             arrDepTimes.add(new ArrDepTimes(a[i], d[i]));
         }
         arrDepTimes.sort(Comparator.comparingInt(o -> o.a));
         return arrDepTimes.toArray(new ArrDepTimes[0]);
    }
}
