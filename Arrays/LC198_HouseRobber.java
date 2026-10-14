/*
 * LeetCode 198 - House Robber
 *
 * Difficulty: Medium
 * Topic: Array, Dynamic Programming
 *
 * Approach:
 * - At each house i, rob either:
 *   1) current house + max money from two houses back (nums[i] + prev2)
 *   2) skip current house (prev1)
 * - Track two previous optimal values to optimize space to O(1).
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int prev2 = 0;
        int prev1 = 0;

        for (int num : nums) {
            int current = Math.max(prev1, prev2 + num);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}
