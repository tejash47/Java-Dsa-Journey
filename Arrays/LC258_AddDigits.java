/*
 * LeetCode 258 - Add Digits
 * Difficulty: Easy
 * Topic: Math, Digital Root
 *
 * Approach:
 * - Use the digital-root property for non-negative integers.
 * - A non-zero number's digital root is 1 + (num - 1) % 9.
 * - Handle zero separately because its digital root is zero.
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */

class Solution {
    public int addDigits(int num) {
        if (num == 0) {
            return 0;
        }

        return 1 + (num - 1) % 9;
    }
}
