package org.am.two.pointer;

/**
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
 * Find and return the maximum profit you can achieve.
 */
public class Stock2 {

    public int maxProfit(int[] prices) {
        int profit = 0, hold = 0, cur = 0;

        // hold if stock price is increasing
        // if stock price is set to decrease
            // book profit
            // buy stock
        while(cur != prices.length) {
            if (cur > 0 && prices[cur] < prices[cur - 1]) {
                profit += prices[cur - 1] - prices[hold];
                hold = cur;
            }
            cur++;
        }

        // book any profit off of the last day
        if (prices[cur - 1] > prices[hold])
            profit += prices[cur - 1] - prices[hold];
        return profit;
    }
}
