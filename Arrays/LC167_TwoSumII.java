/*
 * LeetCode 167 - Two Sum II - Input Array Is Sorted
 *
 * Difficulty: Medium
 * Topic: Arrays, Two Pointers
 *
 * Approach:
 * - Since the array is sorted, use two pointers.
 * - Move left or right pointer based on the current sum.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {

            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1};
            }

            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{};
    }
}