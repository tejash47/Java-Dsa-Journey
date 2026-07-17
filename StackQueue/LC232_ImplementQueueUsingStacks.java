/*
 * LeetCode 232 - Implement Queue using Stacks
 *
 * Difficulty: Easy
 * Topic: Queue, Stack
 *
 * Approach:
 * - Use two stacks:
 *   - inputStack for push operations.
 *   - outputStack for pop and peek operations.
 * - When outputStack is empty, transfer all elements from inputStack.
 *
 * Time Complexity:
 * - push(): O(1)
 * - pop(): Amortized O(1)
 * - peek(): Amortized O(1)
 * - empty(): O(1)
 *
 * Space Complexity: O(n)
 */

import java.util.Stack;

class MyQueue {

    private Stack<Integer> inputStack;
    private Stack<Integer> outputStack;

    public MyQueue() {

        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }

    public void push(int x) {

        inputStack.push(x);
    }

    public int pop() {

        peek();
        return outputStack.pop();
    }

    public int peek() {

        if (outputStack.isEmpty()) {

            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }

        return outputStack.peek();
    }

    public boolean empty() {

        return inputStack.isEmpty() && outputStack.isEmpty();
    }
}