/*
 * LeetCode 153 - Find Minimum in Rotated Sorted Array
 *
 * Difficulty: Medium
 * Topic: Array, Binary Search
 *
 * Approach:
 * - Binary search comparing nums[mid] with nums[right].
 * - If nums[mid] > nums[right], the inflection/minimum point is in the right half (left = mid + 1).
 * - Otherwise, the minimum is at mid or in the left half (right = mid).
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }
}
