/*
 * LeetCode 739 - Daily Temperatures
 *
 * Difficulty: Medium
 * Topic: Stack, Monotonic Stack
 *
 * Approach:
 * - Use a monotonic decreasing stack to store indices.
 * - While the current temperature is greater than the
 *   temperature at the top index, update the answer.
 * - Push the current index onto the stack.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.Stack;

class Solution {

    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] answer = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() &&
                   temperatures[i] > temperatures[stack.peek()]) {

                int index = stack.pop();
                answer[index] = i - index;
            }

            stack.push(i);
        }

        return answer;
    }
}