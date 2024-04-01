package org.am.heap;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class KClosest {

    private record Point(int x, int y, int dist) implements Comparable<Point> { // Note this usage of comparable
        @Override
        public int compareTo(Point o) {
            return this.dist - o.dist;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        List<Point> list = new LinkedList<>();
        for (int[] point : points) { // O(n)
            int x = point[0]; // Note this usage
            int y = point[1];
            list.add(new Point(x, y, x * x + y * y));
        }

        PriorityQueue<Point> pq = new PriorityQueue<>(list);
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) { // O(klogn)
            Point point = pq.remove();
            result[i][0] = point.x;
            result[i][1] = point.y;
        }
        return result;
    }
}
