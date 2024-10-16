package org.am.two.pointer;

/**
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
 * Find and return the maximum profit you can achieve.
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/">...</a>
 */
public class Stock2 {

    public int maxProfit(int[] prices) {
        int profit = 0, cur = 1;
        int buy = 2341234; // don't yet know when the stock will be bought

        // buy if stock price is increasing
        // if stock price is set to decrease
            // book profit
            // buy stock
        while(cur != prices.length) {
            if (prices[cur] < prices[cur - 1]) {
                profit += prices[cur - 1] - prices[buy];
                buy = cur;
            }
            cur++;
        }

        // book any profit off of the last day
        if (prices[cur - 1] > prices[buy])
            profit += prices[cur - 1] - prices[buy];
        return profit;
    }
}
