/*
 * LeetCode 70 - Climbing Stairs
 *
 * Difficulty: Easy
 * Topic: Dynamic Programming, Math, Memoization
 *
 * Approach:
 * - Fibonacci progression: steps to reach step n is (steps to n-1) + (steps to n-2).
 * - Keep two variables for previous steps to achieve O(1) space.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int prev2 = 1;
        int prev1 = 2;

        for (int i = 3; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}
