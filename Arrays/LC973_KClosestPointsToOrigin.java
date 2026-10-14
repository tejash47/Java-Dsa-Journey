/*
 * LeetCode 973 - K Closest Points to Origin
 *
 * Difficulty: Medium
 * Topic: Array, Math, Divide and Conquer, Geometry, Sorting, Heap (Priority Queue), Quickselect
 *
 * Approach:
 * - Use a max-heap of size k ordered by squared Euclidean distance (x^2 + y^2).
 * - Keep smallest k distances in heap; top is furthest among the k.
 *
 * Time Complexity: O(n log k)
 * Space Complexity: O(k)
 */

import java.util.*;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[0] * b[0] + b[1] * b[1], a[0] * a[0] + a[1] * a[1])
        );

        for (int[] p : points) {
            maxHeap.offer(p);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }

        return result;
    }
}
