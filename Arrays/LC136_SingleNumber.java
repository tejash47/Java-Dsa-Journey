/*
 * LeetCode 136 - Single Number
 *
 * Difficulty: Easy
 * Topic: Arrays, Bit Manipulation
 *
 * Approach:
 * - XOR all elements.
 * - Duplicate numbers cancel each other.
 * - The remaining number is the answer.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public int singleNumber(int[] nums) {

        int ans = 0;

        for (int num : nums) {
            ans ^= num;
        }

        return ans;
    }
}