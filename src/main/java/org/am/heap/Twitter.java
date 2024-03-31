package org.am.heap;

import java.util.*;

public class Twitter {

    private static final int NUM_TWEETS_IN_TIMELINE = 10;

    private record Tweet(int userId, int tweetId, long epoch){}

    private final Map<Integer, ArrayList<Tweet>> tweetMap = new HashMap<>();

    private final Map<Integer, Set<Integer>> followeeMap = new HashMap<>();

    private long counter = 0;
    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, key -> new ArrayList<>());
        tweetMap.get(userId).addFirst(new Tweet(userId, tweetId, counter++));
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> users = new LinkedList<>();
        users.add(userId);
        users.addAll(followeeMap.getOrDefault(userId, new HashSet<>()));

        PriorityQueue<Tweet> timeLine = new PriorityQueue<>(Comparator.comparingLong(Tweet::epoch).reversed());

        // O(nk)
        for (int i = 0; i < NUM_TWEETS_IN_TIMELINE; i++) { // O(k)
            for (int user : users) { // O(n)
                ArrayList<Tweet> tweets = tweetMap.getOrDefault(user, new ArrayList<>());
                if (i < tweets.size()) {
                    // choice of arraylist helps with O(1) access
                    Tweet tweet = tweets.get(i);
                    timeLine.add(tweet);
                }
            }
        }

        // O(klogk)
        List<Integer> tweetIds = new LinkedList<>();
        for (int i = 0; i < NUM_TWEETS_IN_TIMELINE && !timeLine.isEmpty(); i++) { //O(k)
            tweetIds.add(timeLine.remove().tweetId);// O(logk)
        }

        return tweetIds;
    }

    public void follow(int followerId, int followeeId) {
        followeeMap.computeIfAbsent(followerId, key -> new HashSet<>());
        followeeMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followeeMap.containsKey(followerId))
            followeeMap.get(followerId).remove(followeeId);
    }
}
