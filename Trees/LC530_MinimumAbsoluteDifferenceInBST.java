/*
 * LeetCode 530 - Minimum Absolute Difference in BST
 *
 * Difficulty: Easy
 * Topic: Tree, Depth-First Search, Breadth-First Search, Binary Search Tree, Binary Tree
 *
 * Approach:
 * - In-order traversal visits BST nodes in sorted order.
 * - Maintain the previously visited node value to compute adjacent differences.
 * - Update minDiff at each step.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h) recursion stack
 */

class Solution {
    private Integer prev = null;
    private int minDiff = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return minDiff;
    }

    private void inOrder(TreeNode node) {
        if (node == null) return;

        inOrder(node.left);

        if (prev != null) {
            minDiff = Math.min(minDiff, node.val - prev);
        }
        prev = node.val;

        inOrder(node.right);
    }
}
