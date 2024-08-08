package org.am.concurrency.message_queue.pull_based;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
class Test {
    private static final Random random = new Random();

    record Consumer(Subscription subscription) implements Callable<Boolean> {

        @Override
        public Boolean call() throws Exception {
            int counter = 1000;
            do {
                String msg = subscription.pull();

                if (msg != null) {
                    print(msg);
                    //Thread.sleep(random.nextInt(1000)); // to mock consumption of message
                } else // long poll
                    Thread.sleep(10000);
                counter--;
            } while (counter > 0);
            return true;
        }
    }

    record Producer(Topic topic) implements Runnable {

        @Override
        public void run() {
            IntStream.range(0, 10).forEach(i -> topic.publish(Thread.currentThread().threadId() + "-msg-" + i));
        }
    }

    private static void print(String msg) {
        System.out.println(Thread.currentThread().threadId() + " : " + msg);
    }

    public static void main(String[] args) throws InterruptedException {
        Broker broker = new Broker();
        Topic topic = broker.createTopic();
        // Multiple concurrent producers over the same topic
        IntStream.range(0, 2).forEach(i -> new Thread(new Producer(topic)).start());
        Subscription subscription = broker.subscribe(topic);
        List<Consumer> consumers = IntStream.range(0, 2).mapToObj(i -> new Consumer(subscription)).collect(Collectors.toList());
        try(ExecutorService executorService = Executors.newCachedThreadPool()) {
            executorService.invokeAll(consumers);
        }
    }
}
