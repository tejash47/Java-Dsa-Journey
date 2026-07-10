/*
 * LeetCode 66 - Plus One
 *
 * Difficulty: Easy
 * Topic: Arrays
 *
 * Approach:
 * - Traverse the array from the last digit.
 * - If the digit is less than 9, increment it and return.
 * - If the digit is 9, set it to 0 and continue.
 * - If all digits are 9, create a new array with an extra digit.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {

            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;

        return result;
    }
}