/*
 * LeetCode 235 - Lowest Common Ancestor of a Binary Search Tree
 *
 * Difficulty: Medium
 * Topic: Tree, Depth-First Search, Binary Search Tree, Binary Tree
 *
 * Approach:
 * - Exploit BST ordering properties:
 *   - If both p and q have values smaller than root.val, LCA is in left subtree.
 *   - If both have values greater than root.val, LCA is in right subtree.
 *   - Otherwise, root is the split point and hence the LCA.
 *
 * Time Complexity: O(h)
 * Space Complexity: O(1) iterative
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;

        while (curr != null) {
            if (p.val < curr.val && q.val < curr.val) {
                curr = curr.left;
            } else if (p.val > curr.val && q.val > curr.val) {
                curr = curr.right;
            } else {
                return curr;
            }
        }

        return null;
    }
}
