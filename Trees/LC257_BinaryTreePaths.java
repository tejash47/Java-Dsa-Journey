/*
 * LeetCode 257 - Binary Tree Paths
 *
 * Difficulty: Easy
 * Topic: String, Backtracking, Tree, Depth-First Search, Binary Tree
 *
 * Approach:
 * - DFS traversal appending node values to path string.
 * - When reaching a leaf (node.left == null && node.right == null), add path to result list.
 *
 * Time Complexity: O(n * h)
 * Space Complexity: O(h) recursion stack
 */

import java.util.*;

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root != null) dfs(root, "", paths);
        return paths;
    }

    private void dfs(TreeNode node, String path, List<String> paths) {
        if (path.isEmpty()) {
            path += node.val;
        } else {
            path += "->" + node.val;
        }

        if (node.left == null && node.right == null) {
            paths.add(path);
            return;
        }

        if (node.left != null) dfs(node.left, path, paths);
        if (node.right != null) dfs(node.right, path, paths);
    }
}
