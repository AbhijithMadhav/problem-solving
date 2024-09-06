package org.am.heap;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/k-closest-points-to-origin/description/">...</a>
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k,
 * return the k closest points to the origin (0, 0).
 * The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
 * You may return the answer in any order.
 * The answer is guaranteed to be unique (except for the order that it is in).
 * Constraints:
 * 1 <= k <= points.length <= 10^4
 * -10^4 <= xi, yi <= 10^4
 */
public class KClosest {

    private record Point(int x, int y, int dist)  {}
    public int[][] kClosest(int[][] points, int k) {

        List<Point> pointList = Arrays.stream(points)
                .map(xy -> new Point(xy[0], xy[1], xy[0] * xy[0] + xy[1] * xy[1]))
                .toList(); // O(n)
        PriorityQueue<Point> pq = new PriorityQueue<>((p1, p2) -> p2.dist - p1.dist);
        for (Point point : pointList) { // n log k
            pq.add(point);
            if (pq.size() > k)
                pq.remove();
        }
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) { // O(k log k)
            Point point = pq.remove();
            result[i][0] = point.x;
            result[i][1] = point.y;
        }
        return result;
    }
}
