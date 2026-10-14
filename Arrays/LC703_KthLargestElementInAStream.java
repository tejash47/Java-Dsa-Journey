/*
 * LeetCode 703 - Kth Largest Element in a Stream
 *
 * Difficulty: Easy
 * Topic: Tree, Design, Binary Search Tree, Heap (Priority Queue), Binary Tree, Data Stream
 *
 * Approach:
 * - Use a min-heap of capacity k.
 * - Keep only the top k largest elements in the heap.
 * - The root (peek) of the min-heap is always the kth largest element.
 *
 * Time Complexity: O(n log k) init, O(log k) add
 * Space Complexity: O(k)
 */

import java.util.*;

class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        minHeap.offer(val);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
