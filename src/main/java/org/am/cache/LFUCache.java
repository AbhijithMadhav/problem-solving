package org.am.cache;

import java.util.*;

public class LFUCache {

    private final int capacity;
    private final Map<Integer, ValueAndFreq> cache = new HashMap<>();
    private final Map<Integer, LinkedHashSet<Integer>> freqMap = new HashMap<>();

    private int minFreq = Integer.MAX_VALUE;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int k) {
        if (!cache.containsKey(k))
            return -1;
        ValueAndFreq vf = cache.get(k);
        updateAccessFrequency(k, vf);
        return vf.value;
    }

    public void put(int k, int v) {
        ValueAndFreq vf;
        if (cache.containsKey(k)) {
            vf = cache.get(k);
            vf.value = v;
        } else {
            if (cache.size() == capacity)
                evictLFU();
            vf = new ValueAndFreq(v);
            cache.put(k, vf);
        }
        updateAccessFrequency(k, vf);
    }

    private void evictLFU() {
        cache.remove(freqMap.get(minFreq).removeLast());
    }

    private void updateAccessFrequency(int k, ValueAndFreq vf) {

        // Remove mapping from current frequency
        if (vf.freq > 0) {
            freqMap.get(vf.freq).remove(k);
            if (freqMap.get(vf.freq).isEmpty())
                freqMap.remove(vf.freq);
        }

        // increment frequency
        vf.freq++;
        if (vf.freq == 1 // New access
                || (!freqMap.containsKey(vf.freq - 1) && minFreq == vf.freq - 1)) // Tracked min freq ticket up
            minFreq = vf.freq;


        // Map to new incremented frequency
        LinkedHashSet<Integer> values = freqMap.computeIfAbsent(vf.freq, key -> new LinkedHashSet<>());
        values.addFirst(k);
    }

    private static class ValueAndFreq {

        private int value;
        private int freq;

        public ValueAndFreq(int value) {
            this.value = value;
        }
    }
}

