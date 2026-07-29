/*
 * LeetCode 112 - Path Sum
 *
 * Difficulty: Easy
 * Topic: Trees, DFS, Recursion
 *
 * Approach:
 * - If the current node is null, return false.
 * - If it's a leaf node, check whether the remaining target equals the node's value.
 * - Recursively search the left and right subtrees with the updated target sum.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 *
 * where:
 * n = number of nodes
 * h = height of the tree
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    public boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        return hasPathSum(root.left, targetSum - root.val) ||
               hasPathSum(root.right, targetSum - root.val);
    }
}