/*
 * LeetCode 424 - Longest Repeating Character Replacement
 *
 * Difficulty: Medium
 * Topic: Strings, Sliding Window
 *
 * Approach:
 * - Maintain a sliding window.
 * - Track the frequency of each character in the window.
 * - Keep the most frequent character count.
 * - If the number of characters that need replacement exceeds k,
 *   shrink the window from the left.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public int characterReplacement(String s, int k) {

        int[] frequency = new int[26];

        int left = 0;
        int maxFrequency = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            int index = s.charAt(right) - 'A';
            frequency[index]++;

            maxFrequency = Math.max(maxFrequency, frequency[index]);

            int windowLength = right - left + 1;

            // Characters that need replacement
            int replacements = windowLength - maxFrequency;

            if (replacements > k) {
                frequency[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}