/*
 * LeetCode 344 - Reverse String
 *
 * Difficulty: Easy
 * Topic: String, Two Pointers, Array
 *
 * Approach:
 * - Use two pointers at the beginning and end.
 * - Swap the characters at both pointers.
 * - Move the pointers toward the center.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public void reverseString(char[] s) {

        int left = 0;
        int right = s.length - 1;

        while (left < right) {

            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }
}