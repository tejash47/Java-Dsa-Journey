/*
 * LeetCode 567 - Permutation in String
 *
 * Difficulty: Medium
 * Topic: Strings, Sliding Window
 *
 * Approach:
 * - Maintain character frequencies for s1 and the current window in s2.
 * - Keep the window size equal to s1.length().
 * - If the frequency arrays match, the window contains a permutation
 *   of s1.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }

        if (matches(count1, count2)) {
            return true;
        }

        for (int i = s1.length(); i < s2.length(); i++) {

            count2[s2.charAt(i) - 'a']++;
            count2[s2.charAt(i - s1.length()) - 'a']--;

            if (matches(count1, count2)) {
                return true;
            }
        }

        return false;
    }

    private boolean matches(int[] a, int[] b) {

        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }

        return true;
    }
}