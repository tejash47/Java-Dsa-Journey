/*
 * LeetCode 100 - Same Tree
 *
 * Difficulty: Easy
 * Topic: Trees, DFS, Recursion
 *
 * Approach:
 * - If both nodes are null, return true.
 * - If one node is null or values differ, return false.
 * - Recursively compare the left and right subtrees.
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

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) &&
               isSameTree(p.right, q.right);
    }
}