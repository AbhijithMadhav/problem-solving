package org.am.concurrency.message_queue.pull_based;

public class Broker {

    public Topic createTopic(){
        return new Topic();
    }

    public Subscription subscribe(Topic topic){
        return new Subscription(topic);
    }

}
