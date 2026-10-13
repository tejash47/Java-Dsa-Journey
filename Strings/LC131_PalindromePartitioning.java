/*
 * LeetCode 131 - Palindrome Partitioning
 *
 * Difficulty: Medium
 * Topic: String, Backtracking, Recursion
 *
 * Approach:
 * - Use backtracking to explore all possible partitions.
 * - Check whether each substring is a palindrome.
 * - If it is, add it to the current partition and recurse.
 * - When the entire string is processed, save the partition.
 *
 * Time Complexity: O(n * 2^n)
 * Space Complexity: O(n)
 */

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<List<String>> partition(String s) {

        List<List<String>> result = new ArrayList<>();

        backtrack(s, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(
            String s,
            int start,
            List<String> current,
            List<List<String>> result) {

        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int end = start; end < s.length(); end++) {

            if (isPalindrome(s, start, end)) {

                current.add(s.substring(start, end + 1));

                backtrack(s, end + 1, current, result);

                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}