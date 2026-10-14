/*
 * LeetCode 230 - Kth Smallest Element in a BST
 *
 * Difficulty: Medium
 * Topic: Tree, Depth-First Search, Binary Search Tree, Binary Tree
 *
 * Approach:
 * - In-order traversal of a BST visits nodes in strictly ascending order.
 * - Traverse left, decrement k on visit, return value when k reaches 0.
 *
 * Time Complexity: O(h + k)
 * Space Complexity: O(h) recursion stack
 */

class Solution {
    private int count = 0;
    private int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inOrder(root);
        return result;
    }

    private void inOrder(TreeNode node) {
        if (node == null || count <= 0) return;

        inOrder(node.left);

        count--;
        if (count == 0) {
            result = node.val;
            return;
        }

        inOrder(node.right);
    }
}
