/*
 * LeetCode 213 - House Robber II
 *
 * Difficulty: Medium
 * Topic: Array, Dynamic Programming
 *
 * Approach:
 * - Houses are arranged in a circle, so the first and last houses cannot both be robbed.
 * - Break into two linear subproblems:
 *   1) Rob houses from 0 to n - 2
 *   2) Rob houses from 1 to n - 1
 * - Return the maximum of both runs.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        return Math.max(robLinear(nums, 0, nums.length - 2),
                        robLinear(nums, 1, nums.length - 1));
    }

    private int robLinear(int[] nums, int start, int end) {
        int prev2 = 0;
        int prev1 = 0;

        for (int i = start; i <= end; i++) {
            int current = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}
