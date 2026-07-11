/*
 * LeetCode 69 - Sqrt(x)
 *
 * Difficulty: Easy
 * Topic: Binary Search
 *
 * Approach:
 * - Use Binary Search to find the integer square root.
 * - Search within the range [1, x].
 * - If mid² is equal to x, return mid.
 * - If mid² is less than x, search the right half.
 * - Otherwise, search the left half.
 * - Return the floor value of the square root.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

class Solution {

    public int mySqrt(int x) {

        if (x < 2) {
            return x;
        }

        long left = 1;
        long right = x;
        int ans = 0;

        while (left <= right) {

            long mid = left + (right - left) / 2;
            long square = mid * mid;

            if (square == x) {
                return (int) mid;
            }

            if (square < x) {
                ans = (int) mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
}