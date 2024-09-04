# LRU cache

The intuition is to use a map so that the `get` and `put` operations are fast.

How can the LRU entry be kept track off? Conceptually, a timestamp associated with each entry can be maintained.
Eviction when the cache is full will consist of searching for the entry with the oldest timestamp.
This search will be slow.

The solution calls for maintaining an LRU order amongst the cache entries. 
The timestamp is one way of arriving at an LRU order, albeit slowly.
An efficient way to maintain this ordering is via a list.
The head of the list is the LRU element and the tail is the MRU element.
Eviction now translates to removing the entry pointed to by the head of the list.
This ordering can be maintained by removing the accessed element from the list and putting it to the end.

In Java, the list interface does not expose references to individual elements. 
Hence, a remove operation is an O(n) operation. 
That rules out using a map and a list in Java.
A `LinkedHashMap` is provided for exactly this reason.
A list is maintained amongst all the elements of the map and an insert order is maintained.
Elements can be `putFirst` or `putLast`. This combined with the map's `remove` operation helps implement the LRU cache.

# MRU cache
An MRU cache is, hopefully, a theoretical experiment.

Its realization is very similar to the LRU cache. The tail of the list is the MRU element while the head is the LRU.
During eviction, the tail of the list is thus removed.

# LFU cache

The intuition is to maintain counts of the access to the elements to keep track of the LFU.
Determining the LFU then involves searching for the element with the least count which is inefficient.

Can a heap be easily to do this? 
Counts keep ticking up with every access. A heap won't remain a heap if the value of its elements is modified.

Could instead use a list whose elements are referenced by the cache.
Since the count of an element ticks upward by one with every access, 
the element can be swapped with its neighboring elements to maintain the sorted order. 

However, this implementation is not possible with the Java list interface as explained in the LRU section.

The alternative is to maintain a map where the key is the access frequency of the entries stored in the cache. 
It is not obvious as to how the entry with the LF count can be kept track off. 
The trick here is to realize that it is now enough to keep track of the lowest access frequency 
and not necessarily the element with the lowest access frequency.
Once this is done, the frequency map can be used to access the element itself.

The frequency of any element starts with 1 and increments by steps of 1 monotonically. 
The min frequency can change in two scenarios
1. A new element is added to the cache. Its access frequency will be 1, the lowest. The min frequency must reflect this.
2. When the element with the lowest frequency is accessed, its frequency ticks ahead by 1. 
   **If there are no other elements with the lowest frequency**, the min frequency should track this uptick.

So the min frequency of the LRU cache can be kept track by modifying the same during the above two executions.


   


