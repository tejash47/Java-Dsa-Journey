/*
 * LeetCode 150 - Evaluate Reverse Polish Notation
 *
 * Difficulty: Medium
 * Topic: Array, Math, Stack
 *
 * Approach:
 * - Use a stack to store operands.
 * - When encountering an operator (+, -, *, /), pop two operands, apply operator, and push result.
 * - Final answer is top of the stack.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (token.equals("-")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a - b);
            } else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a / b);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}
