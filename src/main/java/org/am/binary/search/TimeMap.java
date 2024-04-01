package org.am.binary.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Design a time-based key-value data structure that can store multiple values for the same key at different time stamps and retrieve the key's value at a certain timestamp.
 * Implement the TimeMap class:
 * TimeMap() Initializes the object of the data structure.
 * void set(String key, String value, int timestamp) Stores the key with the value at the given time timestamp.
 * String get(String key, int timestamp) Returns a value such that set was called previously, with timestamp_prev <= timestamp. If there are multiple such values, it returns the value associated with the largest timestamp_prev. If there are no values, it returns "".
 */
public class TimeMap {

    private final Map<String, ArrayList<Value>> store;
    private record Value(String valueString, int timestamp){}
    public TimeMap() {
        store = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        store.computeIfAbsent(key, s -> new ArrayList<>());
        store.get(key).add(new Value(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!store.containsKey(key))
            return "";

        ArrayList<Value> list = store.get(key);

        int l = 0, r = list.size() - 1;
        String result = "";
        while (l <= r) {
            int mid = (l + r) / 2;
            Value value = list.get(mid);
            if (value.timestamp == timestamp)
                return value.valueString;
            if (value.timestamp > timestamp)
                r = mid - 1;
            else {
                l = mid + 1;
                result = value.valueString;
            }
        }
        return result;
    }
}
