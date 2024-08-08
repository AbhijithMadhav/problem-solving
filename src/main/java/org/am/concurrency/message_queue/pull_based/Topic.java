package org.am.concurrency.message_queue.pull_based;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Topic {
    final List<String> queue = Collections.synchronizedList(new ArrayList<>());

    public void publish(String message) {
        queue.add(message);
    }
}
