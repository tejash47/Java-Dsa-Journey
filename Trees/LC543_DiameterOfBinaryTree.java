/*
 * LeetCode 543 - Diameter of Binary Tree
 *
 * Difficulty: Easy
 * Topic: Trees, DFS, Recursion
 *
 * Approach:
 * - Use DFS to calculate the height of each subtree.
 * - At every node, update the maximum diameter as:
 *      leftHeight + rightHeight
 * - Return the height of the current subtree.
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

    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        height(root);
        return diameter;
    }

    private int height(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        diameter = Math.max(diameter, leftHeight + rightHeight);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}