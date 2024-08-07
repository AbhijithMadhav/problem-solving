package org.am.two.pointer;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
public class Stock {

    public int maxProfit(int[] prices) {
        int buy = 0, sell = 0, maxProfit = Integer.MIN_VALUE;
        while (sell != prices.length) { // until I've evaluated selling on every day for profit
            if (prices[sell] < prices[buy]) {
                buy = sell; // if price is lower I'd rather buy
            }
            maxProfit = Math.max(maxProfit, prices[sell] - prices[buy]);
            sell++;
        }
        return maxProfit;
    }
}
