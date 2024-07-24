package org.am.graphs.bfs;

import java.util.*;
import java.util.stream.IntStream;

/**
 * <a href="https://leetcode.com/problems/course-schedule/">...</a>
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take
 * course bi first if you want to take course ai.
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 */
public class CourseScheduleBFS {

    private final Set<Integer> visited = new HashSet<>();
    private final Map<Integer, List<Integer>> adjMap = new HashMap<>();


    public boolean canFinish(int numCourses, int[][] prerequisites) {

        IntStream.range(0, numCourses).forEach(i -> adjMap.put(i, new LinkedList<>()));
        // Construct adjMap
        for (int[] prerequisite: prerequisites) {
            int w = prerequisite[0];
            int v = prerequisite[1];
            adjMap.get(v).add(w);
        }

        /// Find if cycle exists in the graph.
        // Since there can be multiple disjointed graphs, the check has to be done starting all verticies
        for (int start : adjMap.keySet()) {
            if (!visited.contains(start) && hasCycleBFS(start))
                return false;
        }
        return true;
    }

    public boolean hasCycleBFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);
        while(!queue.isEmpty()) {
            List<Integer> neighbors = adjMap.get(queue.remove());
            for (int neighbor : neighbors) {
               if(neighbor == start) // CRUX
                    return true;
               queue.addAll(neighbors);
            }
        }
        return false;
    }
}
