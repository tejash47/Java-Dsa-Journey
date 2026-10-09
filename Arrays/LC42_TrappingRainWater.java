/*
 * LeetCode 42 - Trapping Rain Water
 *
 * Difficulty: Hard
 * Topic: Array, Two Pointers
 *
 * Approach:
 * - Use two pointers from both ends.
 * - Track the maximum height seen from the left and right.
 * - Process the side with the smaller height.
 * - Water trapped at a position is determined by the smaller
 *   boundary minus the current height.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public int trap(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        int water = 0;

        while (left < right) {

            if (height[left] <= height[right]) {

                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }

                left++;

            } else {

                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }

                right--;
            }
        }

        return water;
    }
}