/*
 * LeetCode 503 - Next Greater Element II
 *
 * Difficulty: Medium
 * Topic: Array, Stack, Monotonic Stack
 *
 * Approach:
 * - Array is circular: simulate array duplication by traversing twice (indices 0 to 2*n - 1) using i % n.
 * - Maintain a monotonic decreasing stack storing element indices.
 * - Pop stack when nums[i % n] > nums[stack.peek()] and record answer.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n];
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                result[stack.pop()] = num;
            }
            if (i < n) {
                stack.push(i);
            }
        }

        return result;
    }
}
