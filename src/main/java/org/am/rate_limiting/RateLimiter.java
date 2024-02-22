package org.am.rate_limiting;

public interface RateLimiter {
    boolean allowRequest(Client client, Timestamp requestTimeStamp);
}
