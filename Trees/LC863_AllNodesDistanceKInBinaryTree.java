/*
 * LeetCode 863 - All Nodes Distance K in Binary Tree
 *
 * Difficulty: Medium
 * Topic: Binary Tree, DFS, BFS, HashMap
 *
 * Approach:
 * - Build parent references for every node using DFS.
 * - Start BFS from the target node.
 * - Traverse left, right, and parent neighbors.
 * - Collect nodes when their distance from the target is k.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {

    private Map<TreeNode, TreeNode> parentMap = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        List<Integer> result = new ArrayList<>();

        if (root == null || target == null) {
            return result;
        }

        buildParentMap(root, null);

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        queue.offer(target);
        visited.add(target);

        int distance = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            if (distance == k) {
                for (TreeNode node : queue) {
                    result.add(node.val);
                }

                return result;
            }

            for (int i = 0; i < size; i++) {

                TreeNode current = queue.poll();

                addNeighbor(current.left, queue, visited);
                addNeighbor(current.right, queue, visited);
                addNeighbor(parentMap.get(current), queue, visited);
            }

            distance++;
        }

        return result;
    }

    private void buildParentMap(TreeNode node, TreeNode parent) {

        if (node == null) {
            return;
        }

        if (parent != null) {
            parentMap.put(node, parent);
        }

        buildParentMap(node.left, node);
        buildParentMap(node.right, node);
    }

    private void addNeighbor(
            TreeNode node,
            Queue<TreeNode> queue,
            Set<TreeNode> visited) {

        if (node != null && visited.add(node)) {
            queue.offer(node);
        }
    }
}