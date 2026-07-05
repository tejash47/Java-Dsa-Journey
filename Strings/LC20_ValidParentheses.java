/*
 * LeetCode 20 - Valid Parentheses
 *
 * Difficulty: Easy
 * Topic: Stack
 *
 * Approach:
 * - Use a stack to keep track of opening brackets.
 * - Push opening brackets onto the stack.
 * - For every closing bracket, check if it matches the top of the stack.
 * - If it doesn't match or the stack is empty, return false.
 * - At the end, the stack should be empty for the string to be valid.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.Stack;

class Solution {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (ch == '(' || ch == '{' || ch == '[') {

                stack.push(ch);

            } else {

                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {

                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}