/*
 * LeetCode 374 - Guess Number Higher or Lower
 *
 * Difficulty: Easy
 * Topic: Binary Search
 *
 * Approach:
 * - Use Binary Search on the range [1, n].
 * - Call the guess() API to compare the guessed number.
 * - Narrow the search range based on the API response.
 * - Return the correct number when guess() returns 0.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if num is higher than the picked number
            1 if num is lower than the picked number
            otherwise return 0
*/

public class Solution extends GuessGame {

    public int guessNumber(int n) {

        int left = 1;
        int right = n;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            int result = guess(mid);

            if (result == 0) {
                return mid;
            }

            if (result < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
