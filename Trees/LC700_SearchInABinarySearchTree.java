/*
 * LeetCode 700 - Search in a Binary Search Tree
 *
 * Difficulty: Easy
 * Topic: Tree, Binary Search Tree, Binary Tree
 *
 * Approach:
 * - Exploit BST property: if val < root.val, search left; if val > root.val, search right.
 * - If root == null or root.val == val, return root.
 *
 * Time Complexity: O(h)
 * Space Complexity: O(1) iterative
 */

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode curr = root;

        while (curr != null && curr.val != val) {
            if (val < curr.val) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        return curr;
    }
}
