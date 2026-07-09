/*
 * LeetCode 392 - Is Subsequence
 *
 * Difficulty: Easy
 * Topic: Strings, Two Pointers
 *
 * Approach:
 * - Use two pointers.
 * - Traverse both strings simultaneously.
 * - Move the pointer of the subsequence only when characters match.
 * - If all characters of the subsequence are matched, return true.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * where:
 * n = length of t
 */

class Solution {

    public boolean isSubsequence(String s, String t) {

        int i = 0;
        int j = 0;

        while (i < s.length() && j < t.length()) {

            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }

            j++;
        }

        return i == s.length();
    }
}