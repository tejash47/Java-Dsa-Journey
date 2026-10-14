/*
 * LeetCode 199 - Binary Tree Right Side View
 *
 * Difficulty: Medium
 * Topic: Tree, Depth-First Search, Breadth-First Search, Binary Tree
 *
 * Approach:
 * - Use level-order BFS traversal.
 * - The last node visited in each level queue is added to the result list.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (i == size - 1) {
                    result.add(current.val);
                }
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
        }

        return result;
    }
}
