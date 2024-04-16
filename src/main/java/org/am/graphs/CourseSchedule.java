package org.am.graphs;

import java.util.*;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take
 * course bi first if you want to take course ai.
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjMap = new HashMap<>();

        // Construct adjMap
        for (int[] prerequisite: prerequisites) {
            int w = prerequisite[0];
            int v = prerequisite[1];
            adjMap.putIfAbsent(v, new LinkedList<>());
            adjMap.putIfAbsent(w, new LinkedList<>());
            adjMap.get(v).add(w);
        }

        // Find if cycle exists in the graph.
        // Since this is a directed graph the check has to be done starting all verticies


        Set<Integer> visited = new HashSet<>();
        Set<Integer> onStack = new HashSet<>();
        for (int start : adjMap.keySet()) {
            if (!visited.contains(start) && hasCycle(start, adjMap, visited, onStack))
                return false;
        }
        return true;
    }

    public boolean hasCycle(int v, Map<Integer, List<Integer>> adjMap, Set<Integer> visited, Set<Integer> onStack) {
        visited.add(v);
        onStack.add(v); // CRUX
        for (int w : adjMap.get(v)) {
            if (onStack.contains(w)) // CRUX
                return true;
            if (!visited.contains(w) && hasCycle(w, adjMap, visited, onStack))
                return true;
        }
        onStack.remove(v); // CRUX
        return false;
    }
}
