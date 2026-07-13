/*
 * LeetCode 441 - Arranging Coins
 *
 * Difficulty: Easy
 * Topic: Binary Search
 *
 * Approach:
 * - Use Binary Search to find the maximum number of complete rows.
 * - Check whether mid * (mid + 1) / 2 is less than or equal to n.
 * - Return the largest valid row count.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

class Solution {

    public int arrangeCoins(int n) {

        long left = 0;
        long right = n;

        while (left <= right) {

            long mid = left + (right - left) / 2;
            long coins = mid * (mid + 1) / 2;

            if (coins == n) {
                return (int) mid;
            }

            if (coins < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return (int) right;
    }
}
