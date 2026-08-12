/*
 * LeetCode 978 - Longest Turbulent Subarray
 *
 * Difficulty: Medium
 * Topic: Arrays, Dynamic Programming, Two Pointers
 *
 * Approach:
 * - Track the length of the current turbulent subarray.
 * - If the comparison between consecutive elements changes
 *   from increasing to decreasing or vice versa, extend the length.
 * - Otherwise, reset the current length.
 * - Keep track of the maximum length.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public int maxTurbulenceSize(int[] arr) {

        if (arr.length == 1) {
            return 1;
        }

        int left = 0;
        int right = 1;
        int maxLength = 1;

        while (right < arr.length) {

            if (arr[right] == arr[right - 1]) {
                left = right;
            } 
            else if (right == arr.length - 1 ||
                     (arr[right] > arr[right - 1]) !=
                     (arr[right + 1] > arr[right])) {

                maxLength = Math.max(maxLength, right - left + 1);
            }

            right++;
        }

        return maxLength;
    }
}