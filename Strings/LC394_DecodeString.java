/*
 * LeetCode 394 - Decode String
 *
 * Difficulty: Medium
 * Topic: String, Stack, Recursion
 *
 * Approach:
 * - Use two stacks: one for repeat counts (countStack) and one for string buffers (stringStack).
 * - When reading digits, compute current k.
 * - When encountering '[', push k and current string buffer onto stacks.
 * - When encountering ']', pop count and previous string buffer, append repeated current buffer.
 *
 * Time Complexity: O(maxK * n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public String decodeString(String s) {
        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<StringBuilder> stringStack = new ArrayDeque<>();
        StringBuilder current = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                countStack.push(k);
                stringStack.push(current);
                current = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                StringBuilder decoded = stringStack.pop();
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    decoded.append(current);
                }
                current = decoded;
            } else {
                current.append(ch);
            }
        }

        return current.toString();
    }
}
