/*
 * LeetCode 373 - Find K Pairs with Smallest Sums
 *
 * Difficulty: Medium
 * Topic: Array, Heap (Priority Queue)
 *
 * Approach:
 * - Use a min-heap storing tuples [sum, i, j] pointing to indices in nums1 and nums2.
 * - Seed min-heap with first elements (i, 0) for i up to min(k, nums1.length).
 * - Repeatedly pop smallest sum pair [i, j], add to result, and push [i, j + 1] if valid.
 *
 * Time Complexity: O(k log min(n, k))
 * Space Complexity: O(min(n, k))
 */

import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return result;

        // Min-heap storing [i, j] representing pair indices
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> 
            Integer.compare(nums1[a[0]] + nums2[a[1]], nums1[b[0]] + nums2[b[1]])
        );

        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            pq.offer(new int[]{i, 0});
        }

        while (k > 0 && !pq.isEmpty()) {
            int[] curr = pq.poll();
            int i = curr[0];
            int j = curr[1];
            result.add(Arrays.asList(nums1[i], nums2[j]));
            k--;

            if (j + 1 < nums2.length) {
                pq.offer(new int[]{i, j + 1});
            }
        }

        return result;
    }
}
