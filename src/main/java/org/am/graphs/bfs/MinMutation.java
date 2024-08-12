package org.am.graphs.bfs;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.com/problems/minimum-genetic-mutation/">...</a>
 */
public class MinMutation {
    public int minMutation(String startGene, String endGene, String[] bank) {

        Set<String> genesInBank = Arrays.stream(bank).collect(Collectors.toSet());
        genesInBank.add(startGene);
        Map<String, Set<String>> adjList = constructAdjList(genesInBank);

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(startGene);
        int minMutations = 0;
        while(!queue.isEmpty()) { // O(n), n is the number of genesInBank in the bank
            List<String> genes = queue.stream().toList();
            queue.clear();
            visited.addAll(genes);
            Set<String> neighbors = getNeighbors(genes, adjList).stream() // O(nm)
                    .filter(g -> !visited.contains(g))
                    .collect(Collectors.toSet());
            if (!neighbors.isEmpty())
                minMutations++;
            if (neighbors.contains(endGene))
                return minMutations;
            queue.addAll(neighbors);
        }
        return -1;
    }

    private static Set<String> getNeighbors(List<String> genes, Map<String, Set<String>> adjList) {
        return genes // n
                .stream()
                .map(adjList::get)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }

    // O(n^2 * m)
    private static Map<String, Set<String>> constructAdjList(Set<String> bank) {
        Map<String, Set<String>> adjList = new HashMap<>();
        for (String gene : bank) { // n
            adjList.putIfAbsent(gene, new HashSet<>());
            for (String possibleNeighbor : bank) {
                if (isMutatable(gene, possibleNeighbor))
                    adjList.get(gene).add(possibleNeighbor);
            }
        }
        return adjList;
    }

    // O(m)
    private static boolean isMutatable(String gene, String mutated) {
        assert gene.length() == mutated.length();
        int mutations = 0;
        for (int i = 0; i < gene.length(); i++) {
            if (gene.charAt(i) != mutated.charAt(i)) {
                mutations++;
                if (mutations > 1)
                    return false;
            }
        }
        return true;
    }
}
