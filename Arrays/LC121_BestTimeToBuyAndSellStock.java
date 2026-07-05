/*
 * LeetCode 121 - Best Time to Buy and Sell Stock
 *
 * Difficulty: Easy
 * Topic: Arrays
 *
 * Approach:
 * - Track the minimum stock price seen so far.
 * - Calculate the maximum profit at each step.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public int maxProfit(int[] prices) {

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {

            if (price < minPrice) {
                minPrice = price;
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }

        return maxProfit;
    }
}