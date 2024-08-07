# Uber ride

## Problem
Imagine at the end of a political conference, republicans and democrats are trying to leave the venue and ordering 
Uber rides at the same time. However, to make sure no fight breaks out in an Uber ride, the software developers at 
Uber come up with an algorithm whereby either an Uber ride can have all democrats or republicans or two Democrats 
and two Republicans. All other combinations can result in a fist-fight.

Your task as the Uber developer is to model the ride requesters as threads. Once an acceptable combination of riders 
is possible, threads are allowed to proceed to ride. Each thread invokes the method seated() when selected by the system
for the next ride. When all the threads are seated, any one of the four threads can invoke the method drive() to inform 
the driver to start the ride.

## Solution 1
Number of republicans and democrats arriving for the cab is modelled by two variables. Cab scheduling can be done by
keeping a track of these variables. Atomic variables aren't the right choice as there are possibly multiple 
modifications and access required of the variables.

The passengers themselves are modelled as threads and an `UberRide` system manages the scheduling.

Since multiple passenger threads can ask to be `seated` concurrently there is a need to protect access and modification
to these variables from concurrent access. This can be done by synchronized blocks or reentrant locks. The former is 
chosen here as the entire method(`seat`) is a quick one and there isn't any scope to break down the critical sections
in a more granular fashion.

Starvation is prevented by prioritizing for scheduling 2 dems and 2 reps ahead of 4 reps or of 4 dems. If this
wasn't the case 2 dems could be starved of scheduling due to the infinitely arriving republicans and vice-versa.

This particular solution solves the scheduling problem. It does not attempt to model the actual waiting behaviour 
of the passenger threads.

### Other observations
- The other thing to note is the main method itself which serves as a test harness. A list of passenger threads are 
generated, submitted and waited upon. The `ExecuteService.invokeAll` does the submission and waiting part 
- The choice of two separate methods for encapsulating the logic of seating dems and reps is to avoid messy `if-else`
in a single method


## Solution 2
This solution models the waiting behaviour of the passenger threads.

The first pattern to consider is the `Thread.wait()` and `Thread.notify()` methods. But since a `notify` can't 
conditionally unblock only the required republican and democrat threads more work will be required.

The other alternative is to use `Semaphore`'s. Two semaphores to block democrat and republican threads until they can be
selectively unblocked.

Since there is a blocking and unblocking actions, locks are used instead of synchronized blocks. These are used to mark
the critical regions in a custom fashion to not include the waits caused by the semaphores.

The other principles of the earlier solution still apply.

The waiting behaviour of the passenger threads is now modelled into the solution. This does not cover the aspect of the
4 selected passenger threads leaving together in the cab.

Consider the following scenario.

```text
29 : Republican arrives...
29 : Rep waits...
30 : Republican arrives...
30 : Rep waits...
31 : Republican arrives...
31 : Rep waits...
32 : Republican arrives...
32 : Driving with 4 republicans and 0 democrats. Waiting republicans = 0, Waiting democrats = 0
29 : Rep seated...
31 : Rep seated...
30 : Rep seated...
```
The republican 32 arriving results in one of the scheduling condition(4 republicans) being met. However, it appears that 
the cab drives away with 32, and it is only later that the other republicans(29, 30, 31) are seated.

There is a need for a synchronization mechanism to hold the car until everybody is seated.

## Solution 3
A cyclic barrier does precisely this. It will hold the passenger thread, whose arrival signaled quorem, from driving
away until the selected passengers are seated.



