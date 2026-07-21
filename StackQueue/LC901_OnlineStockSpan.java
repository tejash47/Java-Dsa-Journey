/*
 * LeetCode 901 - Online Stock Span
 *
 * Difficulty: Medium
 * Topic: Stack, Monotonic Stack
 *
 * Approach:
 * - Maintain a monotonic decreasing stack.
 * - Each stack element stores:
 *      [stock price, span]
 * - Pop all prices less than or equal to the current price.
 * - Accumulate their spans.
 *
 * Time Complexity: O(1) Amortized
 * Space Complexity: O(n)
 */

import java.util.Stack;

class StockSpanner {

    private Stack<int[]> stack;

    public StockSpanner() {

        stack = new Stack<>();
    }

    public int next(int price) {

        int span = 1;

        while (!stack.isEmpty() && stack.peek()[0] <= price) {

            span += stack.pop()[1];
        }

        stack.push(new int[]{price, span});

        return span;
    }
}