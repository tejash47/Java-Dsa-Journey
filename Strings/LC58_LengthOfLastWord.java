/*
 * LeetCode 58 - Length of Last Word
 *
 * Difficulty: Easy
 * Topic: Strings
 *
 * Approach:
 * - Start from the end of the string.
 * - Ignore trailing spaces.
 * - Count characters until the next space or beginning of the string.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public int lengthOfLastWord(String s) {

        int length = 0;
        int i = s.length() - 1;

        // Skip trailing spaces
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // Count the last word
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }
}