/*
 * LeetCode 155 - Min Stack
 *
 * Difficulty: Medium
 * Topic: Stack
 *
 * Approach:
 * - Use two stacks.
 * - One stack stores all values.
 * - The second stack stores the minimum value at each step.
 * - This allows getMin() in O(1).
 *
 * Time Complexity:
 * push() : O(1)
 * pop()  : O(1)
 * top()  : O(1)
 * getMin(): O(1)
 *
 * Space Complexity: O(n)
 */

import java.util.Stack;

class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {

        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {

        stack.push(val);

        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {

        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }

        stack.pop();
    }

    public int top() {

        return stack.peek();
    }

    public int getMin() {

        return minStack.peek();
    }
}