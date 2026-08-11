/*
 * LeetCode 378 - Kth Smallest Element in a Sorted Matrix
 *
 * Difficulty: Medium
 * Topic: Arrays, Heap, Priority Queue
 *
 * Approach:
 * - Use a Min Heap to store the smallest element from each row.
 * - Initially add the first element of every row.
 * - Remove the smallest element and add the next element from
 *   the same row.
 * - Repeat k times.
 * - The last removed element is the kth smallest element.
 *
 * Time Complexity: O(k log n)
 * Space Complexity: O(n)
 *
 * where:
 * n = number of rows
 * k = given position
 */

import java.util.PriorityQueue;

class Solution {

    public int kthSmallest(int[][] matrix, int k) {

        int n = matrix.length;

        PriorityQueue<int[]> minHeap =
                new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Add the first element of every row
        for (int row = 0; row < n; row++) {
            minHeap.offer(new int[]{matrix[row][0], row, 0});
        }

        int answer = 0;

        for (int i = 0; i < k; i++) {

            int[] current = minHeap.poll();

            answer = current[0];

            int row = current[1];
            int col = current[2];

            // Add the next element from the same row
            if (col + 1 < n) {
                minHeap.offer(
                    new int[]{matrix[row][col + 1], row, col + 1}
                );
            }
        }

        return answer;
    }
}