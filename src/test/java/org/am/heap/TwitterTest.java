package org.am.heap;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TwitterTest {

    @Test
    void getNewsFeed() {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 11);
        twitter.postTweet(1, 12);
        assertEquals(List.of(12, 11), twitter.getNewsFeed(1));
        twitter.postTweet(2, 21);
        twitter.postTweet(2, 22);
        twitter.follow(1, 2);
        assertEquals(List.of(22, 21, 12, 11), twitter.getNewsFeed(1));
        twitter.postTweet(3, 31);
        twitter.postTweet(3, 32);
        twitter.postTweet(3, 33);
        twitter.postTweet(3, 34);
        twitter.postTweet(3, 35);
        twitter.postTweet(3, 36);
        twitter.postTweet(3, 37);
        twitter.postTweet(3, 38);
        twitter.postTweet(3, 39);
        twitter.follow(1, 3);
        assertEquals(List.of(39, 38, 37, 36, 35, 34, 33, 32, 31, 22), twitter.getNewsFeed(1));
        twitter.unfollow(1, 2);
        assertEquals(List.of(39, 38, 37, 36, 35, 34, 33, 32, 31, 12), twitter.getNewsFeed(1));

    }
}