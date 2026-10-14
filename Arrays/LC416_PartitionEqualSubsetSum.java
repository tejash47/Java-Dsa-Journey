/*
 * LeetCode 416 - Partition Equal Subset Sum
 *
 * Difficulty: Medium
 * Topic: Array, Dynamic Programming
 *
 * Approach:
 * - Reduce to 0/1 Knapsack: find if a subset sums to totalSum / 2.
 * - If totalSum is odd, return false immediately.
 * - Use boolean array dp of size target + 1, updating backwards to avoid reuse.
 *
 * Time Complexity: O(n * target)
 * Space Complexity: O(target), where target = totalSum / 2
 */

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;

        if (sum % 2 != 0) return false;
        int target = sum / 2;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }
}
