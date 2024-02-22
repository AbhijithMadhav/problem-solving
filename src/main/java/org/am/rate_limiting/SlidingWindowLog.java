package org.am.rate_limiting;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SlidingWindowLog {
    private final long windowSizeMs;
    private final int allowedRequestsPerWindow;

    // Since method access is synchronized this need not be a concurrent hashMap
    private final Map<Request, Set<Timestamp>> requestTimeStampsByRequest = new HashMap<>();
    private final Lock lock = new ReentrantLock(true);

    public SlidingWindowLog(long windowSizeMs, int allowedRequestsPerWindow) {
        this.windowSizeMs = windowSizeMs;
        this.allowedRequestsPerWindow = allowedRequestsPerWindow;
    }

    public boolean allowRequest(Request request, Timestamp requestTimeStamp) {
        try {
            // Since the request if user based don't expect too much contention
            lock.lock();
            return synchronizedCheck(request, requestTimeStamp);
        } finally {
            lock.unlock();
        }
    }

    private boolean synchronizedCheck(Request request, Timestamp requestTimeStamp) {
        int count = 0;
        Set<Timestamp> requestTimeStamps = requestTimeStampsByRequest.get(request);
        if(requestTimeStamps == null) {
            // When there are multiple threads getting requests from the same user the requests timestamps will not be monotonically increasing
            // Hence need a TreeSet instead of a simple list
            requestTimeStamps = new TreeSet<>(
                    Comparator.comparingLong( timestamp -> timestamp.epochMilli)
            );
            requestTimeStampsByRequest.put(request, requestTimeStamps);
        } else {
            // Length of list is bounded by 'allowedRequestsPerWindow'
            Iterator<Timestamp> iterator = requestTimeStamps.iterator();
            while(iterator.hasNext()) {
                Timestamp ts = iterator.next();
                if (ts.epochMilli >= requestTimeStamp.epochMilli - windowSizeMs) {
                    count++;
                } else {
                    iterator.remove();
                }
            }
        }
        System.out.println("Requests in window for " + request + "(" + requestTimeStamp + ") : " + count);
        boolean allowRequest = count <= allowedRequestsPerWindow - 1;
        if (allowRequest) {
            requestTimeStamps.add(requestTimeStamp);
        }
        return allowRequest;
    }

    public record Request(String identity) {}

    public record Timestamp(Long epochMilli) {}
}
