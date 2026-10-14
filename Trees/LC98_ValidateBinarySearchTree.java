/*
 * LeetCode 98 - Validate Binary Search Tree
 *
 * Difficulty: Medium
 * Topic: Tree, Depth-First Search, Binary Search Tree, Binary Tree
 *
 * Approach:
 * - Recursively validate each node with acceptable lower and upper bounds (min, max).
 * - Left child must be in (min, node.val); right child in (node.val, max).
 * - Use Long objects or min/max bounds to handle integer overflow.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h) recursion stack
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    private boolean validate(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;

        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }

        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }
}
