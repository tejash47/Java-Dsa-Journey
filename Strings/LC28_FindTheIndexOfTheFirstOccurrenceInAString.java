/*
 * LeetCode 28 - Find the Index of the First Occurrence in a String
 *
 * Difficulty: Easy
 * Topic: Strings
 *
 * Approach:
 * - Traverse the string from left to right.
 * - At each position, compare the substring with the needle.
 * - Return the starting index if a match is found.
 * - If no match exists, return -1.
 *
 * Time Complexity: O((n - m + 1) * m)
 * Space Complexity: O(1)
 *
 * where:
 * n = length of haystack
 * m = length of needle
 */

class Solution {

    public int strStr(String haystack, String needle) {

        if (needle.length() == 0) {
            return 0;
        }

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {

            int j = 0;

            while (j < needle.length() &&
                   haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            if (j == needle.length()) {
                return i;
            }
        }

        return -1;
    }
}