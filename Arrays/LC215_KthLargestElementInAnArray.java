/*
 * LeetCode 215 - Kth Largest Element in an Array
 *
 * Difficulty: Medium
 * Topic: Array, Divide and Conquer, Sorting, Heap (Priority Queue), Quickselect
 *
 * Approach:
 * - Use a min-heap (PriorityQueue) of size k.
 * - For each number, offer into heap; if size exceeds k, poll the smallest.
 * - The top of the heap after traversal is the kth largest element.
 *
 * Time Complexity: O(n log k)
 * Space Complexity: O(k)
 */

import java.util.*;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }
}
