/*
 * LeetCode 684 - Redundant Connection
 *
 * Difficulty: Medium
 * Topic: Graph, Union-Find (DSU)
 *
 * Approach:
 * - Initially, every node belongs to its own set.
 * - For each edge, find the roots of both nodes.
 * - If both nodes already have the same root, adding this
 *   edge creates a cycle, so it is the redundant edge.
 * - Otherwise, union the two sets.
 *
 * Time Complexity: O(n * α(n)) ≈ O(n)
 * Space Complexity: O(n)
 */

class Solution {

    private int[] parent;
    private int[] rank;

    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;

        parent = new int[n + 1];
        rank = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            if (find(u) == find(v)) {
                return edge;
            }

            union(u, v);
        }

        return new int[0];
    }

    private int find(int node) {

        if (parent[node] != node) {
            parent[node] = find(parent[node]);
        }

        return parent[node];
    }

    private void union(int u, int v) {

        int rootU = find(u);
        int rootV = find(v);

        if (rootU == rootV) {
            return;
        }

        if (rank[rootU] < rank[rootV]) {
            parent[rootU] = rootV;
        } else if (rank[rootU] > rank[rootV]) {
            parent[rootV] = rootU;
        } else {
            parent[rootV] = rootU;
            rank[rootU]++;
        }
    }
}