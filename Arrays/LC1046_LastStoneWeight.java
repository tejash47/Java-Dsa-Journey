/*
 * LeetCode 1046 - Last Stone Weight
 *
 * Difficulty: Easy
 * Topic: Array, Heap (Priority Queue)
 *
 * Approach:
 * - Use a max-heap (Collections.reverseOrder()) to simulate smashing the two heaviest stones.
 * - Pop two stones y and x (y >= x). If y > x, push y - x back into heap.
 * - Return remaining stone or 0 if heap empty.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        while (maxHeap.size() > 1) {
            int y = maxHeap.poll();
            int x = maxHeap.poll();
            if (y > x) {
                maxHeap.offer(y - x);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
