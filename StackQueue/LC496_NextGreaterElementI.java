/*
 * LeetCode 496 - Next Greater Element I
 *
 * Difficulty: Easy
 * Topic: Array, Hash Table, Stack, Monotonic Stack
 *
 * Approach:
 * - Precompute next greater elements for nums2 using a monotonic decreasing stack and HashMap.
 * - For each element in nums2, pop elements from stack that are smaller and map them to current element.
 * - Query map for each element in nums1 (default to -1).
 *
 * Time Complexity: O(n1 + n2)
 * Space Complexity: O(n2)
 */

import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreater = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();

        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                nextGreater.put(stack.pop(), num);
            }
            stack.push(num);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreater.getOrDefault(nums1[i], -1);
        }

        return result;
    }
}
