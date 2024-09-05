package org.am.heap;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/task-scheduler/">...</a>
 */

public class TaskScheduler {

    public int leastInterval(char[] tasks, int len) {
        // Calculate the frequency of tasks
        // put in max heap
        // for each scheduling cycle
        //      remove max and schedule. Update max count
        //      Since the max frequency task is removed from the pq after scheduling in each cycle, there is no chance of the same being scheduled twice
        // Add the removed tasks for scheduling in the next cycle

        Map<Character, Integer> taskMap = new HashMap<>();
        for (char task : tasks) // O(n)
            taskMap.put(task, taskMap.getOrDefault(task, 0) + 1);

        PriorityQueue<Character> pq = new PriorityQueue<>((t1, t2) -> taskMap.get(t2) - taskMap.get(t1));
        pq.addAll(taskMap.keySet());
        int intervals = 0;
        while (!taskMap.isEmpty()) { // O(n)
            Set<Character> scheduledTasks = new HashSet<>();
            for (int i = 0; i <= len; i++) {
                if (taskMap.isEmpty())
                    break;
                if (!pq.isEmpty()) {
                    char task = pq.remove(); // O(26)
                    scheduledTasks.add(task);
                    taskMap.put(task, taskMap.get(task) - 1);
                    if (taskMap.get(task) == 0)
                        taskMap.remove(task);
                }
                intervals++;
            }
            scheduledTasks.forEach(task -> {  // O(len)
                if (taskMap.containsKey(task))
                    pq.add(task); // O(26)
            });
        }
        return intervals;
    }
}
