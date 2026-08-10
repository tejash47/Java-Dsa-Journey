/*
 * LeetCode 295 - Find Median from Data Stream
 *
 * Difficulty: Hard
 * Topic: Heap, Priority Queue
 *
 * Approach:
 * - Use two heaps:
 *   - maxHeap stores the smaller half of the numbers.
 *   - minHeap stores the larger half of the numbers.
 * - Keep the two heaps balanced.
 * - If the total count is odd, maxHeap contains one extra element.
 * - If even, the median is the average of both heap tops.
 *
 * Time Complexity:
 * addNum(): O(log n)
 * findMedian(): O(1)
 *
 * Space Complexity: O(n)
 */

import java.util.PriorityQueue;

class MedianFinder {

    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public MedianFinder() {

        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {

        maxHeap.offer(num);

        if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
            minHeap.offer(maxHeap.poll());
        }

        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        }

        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {

        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }

        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}