package org.am.graphs;

import java.util.*;
import java.util.stream.IntStream;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take
 * course bi first if you want to take course ai.
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 */
public class CourseSchedule {

    private final Set<Integer> visited = new HashSet<>();
    private final Set<Integer> onStack = new HashSet<>();
    private final Deque<Integer> reversePostOrder = new LinkedList<>();
    private final Map<Integer, List<Integer>> adjMap = new HashMap<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        if (canFinish(numCourses, prerequisites)) {
            int[] result = new int[reversePostOrder.size()];
            for (int i = 0; i < result.length; i++)
                result[i] = reversePostOrder.pop();
            return result;
        }
        return new int[]{};
    }


    public boolean canFinish(int numCourses, int[][] prerequisites) {

        IntStream.range(0, numCourses).forEach(i -> adjMap.put(i, new LinkedList<>()));
        // Construct adjMap
        for (int[] prerequisite: prerequisites) {
            int w = prerequisite[0];
            int v = prerequisite[1];
            adjMap.get(v).add(w);
        }

        // Find if cycle exists in the graph.
        // Since there can be multiple disjointed graphs, the check has to be done starting all verticies
        for (int start : adjMap.keySet()) {
            if (!visited.contains(start) && hasCycle(start))
                return false;
        }
        return true;
    }

    public boolean hasCycle(int v) {
        visited.add(v);
        onStack.add(v); // CRUX
        for (int w : adjMap.get(v)) {
            if (onStack.contains(w)) // CRUX
                return true;
            if (!visited.contains(w) && hasCycle(w))
                return true;
        }
        onStack.remove(v); // CRUX
        reversePostOrder.push(v); // CRUx
        return false;
    }
}
