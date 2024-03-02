package org.am.cache;

import java.util.*;

public class LFUCache {

    private final int capacity;
    private final Map<Integer, Value> valueMap = new HashMap<>();
    private final Map<Integer, Deque<Value>> lfumap = new HashMap<>();

    private int lfuCount = Integer.MAX_VALUE;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int k) {
        int v = -1;
        if (valueMap.containsKey(k)) {
            Value value = valueMap.get(k);
            v = value.value;
            updateAccessCount(value);
        }
        return v;
    }

    public void put(int k, int v) {
        Value value;
        if (valueMap.containsKey(k)) {
            value = valueMap.get(k);
            value.value = v;
        } else {
            if (valueMap.size() == capacity) {
                valueMap.remove(lfumap.get(lfuCount).removeLast().key);
            }
            value = new Value(k, v);
            valueMap.put(k, value);
        }
        updateAccessCount(value);
    }

    private void updateAccessCount(Value value) {
        if (value.count > 0) {
            // TODO : This is costly. Can optimize by implementing a custom linked list
            lfumap.get(value.count).remove(value);
            if (lfumap.get(value.count).isEmpty() && lfuCount == value.count)
                lfuCount = value.count + 1;
        }

        value.count++;
        Deque<Value> lfuList = lfumap.computeIfAbsent(value.count, k -> new LinkedList<>());
        lfuList.addFirst(value);
        if (lfuList.size() == 1 && lfuCount > value.count)
            lfuCount = value.count;
    }

    static class Value {

        int key;
        int value;
        int count;

        public Value(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Value value1 = (Value) o;
            return key == value1.key && value == value1.value;
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }
}

