/*
 * LeetCode 239 - Sliding Window Maximum
 *
 * Difficulty: Hard
 * Topic: StackQueue, Monotonic Deque, Sliding Window
 *
 * Approach:
 * - Use a Deque to maintain indices of elements in decreasing order.
 * - Remove indices outside the current window.
 * - Remove smaller elements from the back because they cannot
 *   become the maximum while the current element is present.
 * - The front of the deque always contains the maximum element.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(k)
 */

import java.util.*;

class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] result = new int[n - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            // Remove elements outside the current window
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // Maintain decreasing order
            while (!deque.isEmpty() &&
                   nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            // Window is ready
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}