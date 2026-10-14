/*
 * LeetCode 347 - Top K Frequent Elements
 *
 * Difficulty: Medium
 * Topic: Array, Hash Table, Divide and Conquer, Sorting, Heap (Priority Queue), Bucket Sort
 *
 * Approach:
 * - Count frequencies using HashMap.
 * - Group numbers by frequency using bucket sort array of lists.
 * - Collect numbers from highest frequency bucket down until k numbers are selected.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1];
        for (int key : countMap.keySet()) {
            int freq = countMap.get(key);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }

        int[] result = new int[k];
        int index = 0;

        for (int i = buckets.length - 1; i >= 0 && index < k; i--) {
            if (buckets[i] != null) {
                for (int val : buckets[i]) {
                    result[index++] = val;
                    if (index == k) break;
                }
            }
        }

        return result;
    }
}
