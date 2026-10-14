/*
 * LeetCode 322 - Coin Change
 *
 * Difficulty: Medium
 * Topic: Array, Dynamic Programming, Breadth-First Search
 *
 * Approach:
 * - Bottom-up 1D DP: dp[i] is min coins needed for amount i.
 * - Initialize dp array with amount + 1, set dp[0] = 0.
 * - For each coin and amount i >= coin, dp[i] = min(dp[i], dp[i - coin] + 1).
 *
 * Time Complexity: O(amount * n)
 * Space Complexity: O(amount)
 */

import java.util.*;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
