# Multithreaded message Queue

## Problem
We have to design a message queue supporting publisher-subscriber model. It should support following operations:

- It should support multiple topics where messages can be published.
- Publisher should be able to publish a message to a particular topic.
- Subscribers should be able to subscribe to a topic.
- Whenever a message is published to a topic, all the subscribers, who are subscribed to that topic, 
  should receive the message.
- Subscribers should be able to run in parallel

Solution 1

Message queues are typically pull based today. This solution illustrates such a solution. Here consumers poll the 
message broker for messages.

As a consequence, the main type of concurrency elements in the solution is to protect improper modification of critical  
data structures.
- A subscription maintains the offset which indicates the next message in the queue the consuming thread would want 
  to consume from. In case there are two consumers consuming from the same subscription, this offset can be accessed or 
  modified improperly.
- Similarly, if multiple producers are publishing to a topic, the underlying data structure, a queue or a list, might end 
  up in an inconsistent state

The solution to the first issue is ensuring that access and modification to the offset of a subscription are walled 
by boundaries of a subscription-specific critical region. It is important that the critical region is 
subscription-specific. Else it will result in unnecessary serialization of thread access to this region. Threads belonging to 
 different subscriptions access different offsets and hence need not be protected against one another

The Solution to the second issue is to establish critical regions using synchronized blocks or locks while performing
actions(in this case, adding elements) on the underlying queue/list of the topic. The easier alternative is to convert 
the list into a synchronized one which provides such thread safe operations out-of-box.


Solution 2

To demonstrate thread coordination mechanisms(wait-notify) a push-based solution can be implemented.
TODO