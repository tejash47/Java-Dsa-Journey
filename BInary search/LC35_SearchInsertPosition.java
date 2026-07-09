/*
 * LeetCode 35 - Search Insert Position
 *
 * Difficulty: Easy
 * Topic: Arrays, Binary Search
 *
 * Approach:
 * - Use Binary Search to find the target.
 * - If the target is not present, return the position where it should be inserted.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

class Solution {

    public int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}