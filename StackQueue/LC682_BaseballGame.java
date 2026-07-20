/*
 * LeetCode 682 - Baseball Game
 *
 * Difficulty: Easy
 * Topic: Stack
 *
 * Approach:
 * - Use a stack to store valid scores.
 * - "+" : Push the sum of the previous two scores.
 * - "D" : Push double the previous score.
 * - "C" : Remove the previous score.
 * - Number : Push it onto the stack.
 * - Sum all remaining scores.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.Stack;

class Solution {

    public int calPoints(String[] operations) {

        Stack<Integer> stack = new Stack<>();

        for (String op : operations) {

            switch (op) {

                case "+":
                    int first = stack.pop();
                    int second = stack.peek();
                    stack.push(first);
                    stack.push(first + second);
                    break;

                case "D":
                    stack.push(stack.peek() * 2);
                    break;

                case "C":
                    stack.pop();
                    break;

                default:
                    stack.push(Integer.parseInt(op));
            }
        }

        int sum = 0;

        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }
}