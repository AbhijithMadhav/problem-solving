package org.am.concurrency.message_queue.pull_based;

public class Subscription {

    private final Topic topic;
    private int offset;

    public Subscription(Topic topic) {
        this.topic = topic;
        offset = 0;
    }

    // synchronized prevents concurrent modification of offset in case there are multiple threads for the same subscription
    public synchronized String pull() {
        if (offset >= topic.queue.size())
            return null;
        return topic.queue.get(offset++);
    }
}
