/*
 * LeetCode 15 - 3Sum
 *
 * Difficulty: Medium
 * Topic: Array, Two Pointers, Sorting
 *
 * Approach:
 * - Sort the array first.
 * - Fix one element and use two pointers to find
 *   the remaining two elements.
 * - Skip duplicate values to avoid duplicate triplets.
 *
 * Time Complexity: O(n²)
 * Space Complexity: O(1) excluding the output list
 */

import java.util.*;

class Solution {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicate first elements
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {

                    result.add(Arrays.asList(
                        nums[i],
                        nums[left],
                        nums[right]
                    ));

                    // Skip duplicates
                    while (left < right &&
                           nums[left] == nums[left + 1]) {
                        left++;
                    }

                    while (left < right &&
                           nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;

                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
}