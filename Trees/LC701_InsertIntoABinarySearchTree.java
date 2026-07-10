/*
 * LeetCode 701 - Insert into a Binary Search Tree
 *
 * Difficulty: Medium
 * Topic: Trees, Binary Search Tree (BST)
 *
 * Approach:
 * - If the tree is empty, create a new node.
 * - Compare the value with the current node.
 * - Insert recursively into the left or right subtree.
 * - Return the root after insertion.
 *
 * Time Complexity: O(h)
 * Space Complexity: O(h)
 *
 * where:
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

    public TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }
}