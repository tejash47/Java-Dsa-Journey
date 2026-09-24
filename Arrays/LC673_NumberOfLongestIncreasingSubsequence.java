/*
 * LeetCode 673 - Number of Longest Increasing Subsequence
 *
 * Difficulty: Medium
 * Topic: Arrays, Dynamic Programming
 *
 * Approach:
 * - dp[i] stores the length of the longest increasing subsequence
 *   ending at index i.
 * - count[i] stores the number of LIS ending at index i.
 * - For every previous element smaller than nums[i]:
 *   - Extend the subsequence if it creates a longer length.
 *   - Add the number of ways if it creates another subsequence
 *     with the same maximum length.
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 */

class Solution {

    public int findNumberOfLIS(int[] nums) {

        int n = nums.length;

        int[] dp = new int[n];
        int[] count = new int[n];

        int maxLength = 1;
        int result = 0;

        for (int i = 0; i < n; i++) {

            dp[i] = 1;
            count[i] = 1;

            for (int j = 0; j < i; j++) {

                if (nums[j] < nums[i]) {

                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    }
                    else if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    }
                }
            }

            maxLength = Math.max(maxLength, dp[i]);
        }

        for (int i = 0; i < n; i++) {

            if (dp[i] == maxLength) {
                result += count[i];
            }
        }

        return result;
    }
}