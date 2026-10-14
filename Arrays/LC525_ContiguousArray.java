/*
 * LeetCode 525 - Contiguous Array
 *
 * Difficulty: Medium
 * Topic: Array, Hash Table, Prefix Sum
 *
 * Approach:
 * - Treat 0 as -1 and 1 as +1; the problem reduces to finding maximum length subarray with sum 0.
 * - Use a HashMap storing earliest prefixSum -> index (seed with 0 -> -1).
 * - When a prefixSum repeats, subarray between first occurrence and current index has sum 0.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int maxLen = 0;
        int prefixSum = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += (nums[i] == 1 ? 1 : -1);

            if (map.containsKey(prefixSum)) {
                maxLen = Math.max(maxLen, i - map.get(prefixSum));
            } else {
                map.put(prefixSum, i);
            }
        }

        return maxLen;
    }
}
