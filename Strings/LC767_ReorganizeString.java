/*
 * LeetCode 767 - Reorganize String
 *
 * Difficulty: Medium
 * Topic: Hash Table, String, Greedy, Sorting, Heap (Priority Queue), Counting
 *
 * Approach:
 * - Count frequencies; if maxFreq > (n + 1) / 2, reorganization is impossible (return "").
 * - Fill even indices (0, 2, 4...) first with the most frequent character, then fill rest.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1) 26 alphabet characters
 */

class Solution {
    public String reorganizeString(String s) {
        int[] counts = new int[26];
        int maxFreq = 0;
        char maxChar = ' ';

        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
            if (counts[c - 'a'] > maxFreq) {
                maxFreq = counts[c - 'a'];
                maxChar = c;
            }
        }

        if (maxFreq > (s.length() + 1) / 2) {
            return "";
        }

        char[] res = new char[s.length()];
        int idx = 0;

        // Place most frequent character at even indices
        while (counts[maxChar - 'a'] > 0) {
            res[idx] = maxChar;
            idx += 2;
            counts[maxChar - 'a']--;
        }

        // Place remaining characters
        for (int i = 0; i < 26; i++) {
            while (counts[i] > 0) {
                if (idx >= s.length()) {
                    idx = 1;
                }
                res[idx] = (char) ('a' + i);
                idx += 2;
                counts[i]--;
            }
        }

        return new String(res);
    }
}
