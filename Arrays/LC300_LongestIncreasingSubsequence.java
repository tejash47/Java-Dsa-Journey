/*
 * LeetCode 300 - Longest Increasing Subsequence
 *
 * Difficulty: Medium
 * Topic: Array, Binary Search, Dynamic Programming
 *
 * Approach:
 * - Patience sorting using binary search:
 * - Maintain a tails array where tails[i] stores smallest tail of all increasing subsequences of length i+1.
 * - For each x in nums, binary search for x in tails and replace or append.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int[] tails = new int[nums.length];
        int size = 0;

        for (int x : nums) {
            int i = 0, j = size;
            while (i < j) {
                int mid = i + (j - i) / 2;
                if (tails[mid] < x) {
                    i = mid + 1;
                } else {
                    j = mid;
                }
            }
            tails[i] = x;
            if (i == size) size++;
        }

        return size;
    }
}
