/*
 * LeetCode 238 - Product of Array Except Self
 *
 * Difficulty: Medium
 * Topic: Array, Prefix Sum
 *
 * Approach:
 * - Construct prefix products in the output array in a first pass from left to right.
 * - Accumulate suffix products using a running variable in a second pass from right to left.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1) auxiliary space (output array does not count toward space complexity)
 */

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= suffix;
            suffix *= nums[i];
        }

        return result;
    }
}
