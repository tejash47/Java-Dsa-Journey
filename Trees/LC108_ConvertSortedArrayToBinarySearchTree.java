/*
 * LeetCode 108 - Convert Sorted Array to Binary Search Tree
 *
 * Difficulty: Easy
 * Topic: Array, Divide and Conquer, Tree, Binary Search Tree, Binary Tree
 *
 * Approach:
 * - To ensure height-balance, pick the middle element of the sorted subarray as root.
 * - Recursively construct left subtree from left half and right subtree from right half.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(log n) recursion stack
 */

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int left, int right) {
        if (left > right) return null;

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums, left, mid - 1);
        root.right = buildBST(nums, mid + 1, right);

        return root;
    }
}
