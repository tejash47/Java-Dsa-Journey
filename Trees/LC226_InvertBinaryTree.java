/*
 * LeetCode 226 - Invert Binary Tree
 *
 * Difficulty: Easy
 * Topic: Trees, DFS, Recursion
 *
 * Approach:
 * - If the current node is null, return null.
 * - Swap the left and right child.
 * - Recursively invert both subtrees.
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

    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}