/*
 * LeetCode 62 - Unique Paths
 *
 * Difficulty: Medium
 * Topic: Dynamic Programming, Combinatorics
 *
 * Approach:
 * - Standard 1D/2D DP: dp[j] = dp[j] + dp[j-1].
 * - Each cell (i, j) can only be reached from (i-1, j) and (i, j-1).
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }

        return dp[n - 1];
    }
}
