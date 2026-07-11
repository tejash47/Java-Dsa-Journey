/*
 * LeetCode 367 - Valid Perfect Square
 *
 * Difficulty: Easy
 * Topic: Binary Search
 *
 * Approach:
 * - Use Binary Search on the range [1, num].
 * - Compare the square of the middle value with num.
 * - If equal, return true.
 * - Otherwise, search in the appropriate half.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

class Solution {

    public boolean isPerfectSquare(int num) {

        if (num == 1) {
            return true;
        }

        long left = 1;
        long right = num;

        while (left <= right) {

            long mid = left + (right - left) / 2;
            long square = mid * mid;

            if (square == num) {
                return true;
            }

            if (square < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}