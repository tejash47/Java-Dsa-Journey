/*
 * LeetCode 101 - Symmetric Tree
 *
 * Difficulty: Easy
 * Topic: Tree, Depth-First Search, Breadth-First Search, Binary Tree
 *
 * Approach:
 * - A tree is symmetric if left and right subtrees are mirror reflections of each other.
 * - Recursively check if t1.val == t2.val, and t1.left mirrors t2.right and t1.right mirrors t2.left.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null || t1.val != t2.val) return false;

        return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }
}
