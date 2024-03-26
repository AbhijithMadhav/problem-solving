package org.am.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

class MedianFinder {

    private final PriorityQueue<Integer> minPQ = new PriorityQueue<>(Comparator.comparingInt(o -> o));
    private final PriorityQueue<Integer> maxPQ = new PriorityQueue<>(((o1, o2) -> o2 - o1));

    // The crux of a simple implementation is to insert into maxPQ first.
    // Now two movements might be necessary
    // 1. The element was wrongly added to maxPQ and needs to be moved to minPQ
    // 2. Move element to from minPQ to MaxPQ or vice-versa to ensure balance of PQ's to find median
    // NOTE : Instead of PQ's the same could have been implemented using a linked list. Insertion of elements maintain
    //        order by using binary search
    public void addNum(int num) {
        maxPQ.add(num);
        assert !maxPQ.isEmpty();
       if (!minPQ.isEmpty() && maxPQ.peek() > minPQ.peek())
           minPQ.add(maxPQ.remove()); // element was wrongly added to maxPQ. Move it

        if (maxPQ.size() > minPQ.size() + 1)
            minPQ.add(maxPQ.remove());
        else if (minPQ.size() > maxPQ.size() + 1)
            maxPQ.add(minPQ.remove());
    }

    public double findMedian() {
        assert !minPQ.isEmpty() || !maxPQ.isEmpty();
        if (minPQ.size() == maxPQ.size())
            return (double) (minPQ.peek() + maxPQ.peek()) / 2;
        return minPQ.size() > maxPQ.size() ? minPQ.peek() : maxPQ.peek();
    }
}