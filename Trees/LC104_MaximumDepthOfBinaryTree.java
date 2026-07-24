/*
 * LeetCode 104 - Maximum Depth of Binary Tree
 *
 * Difficulty: Easy
 * Topic: Trees, DFS, Recursion
 *
 * Approach:
 * - Use recursion.
 * - If the current node is null, return 0.
 * - Recursively calculate the depth of the left and right subtrees.
 * - Return the greater depth plus one for the current node.
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
    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int depth = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            depth++;
        }

        return depth;
    }
}