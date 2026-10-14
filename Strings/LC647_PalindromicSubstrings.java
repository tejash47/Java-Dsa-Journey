/*
 * LeetCode 647 - Palindromic Substrings
 *
 * Difficulty: Medium
 * Topic: Two Pointers, String, Dynamic Programming
 *
 * Approach:
 * - Expand around center for all 2n - 1 potential centers (odd length and even length).
 * - Count and expand while characters at left and right match and within bounds.
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 */

class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += expand(s, i, i);     // Odd-length palindromes
            count += expand(s, i, i + 1); // Even-length palindromes
        }
        return count;
    }

    private int expand(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
}
