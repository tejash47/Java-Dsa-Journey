/*
 * LeetCode 886 - Possible Bipartition
 *
 * Difficulty: Medium
 * Topic: Graphs, Breadth-First Search (BFS), Bipartite Graph
 *
 * Approach:
 * - Represent the dislikes as an undirected graph where an edge exists between two people who dislike each other.
 * - The problem reduces to checking whether the graph is bipartite (i.e., can be 2-colored such that no two adjacent nodes have the same color).
 * - Build an adjacency list for all people from 1 to n.
 * - Iterate through all people (1 to n) to handle disconnected components.
 * - If a person is uncolored, assign color 1 and perform BFS:
 *   - For each neighbor, if it has the same color as the current person, bipartition is impossible -> return false.
 *   - If unvisited/uncolored, assign the opposite color and push to the queue.
 * - If all components are successfully 2-colored without conflict, return true.
 *
 * Time Complexity: O(V + E) where V = n and E = dislikes.length
 * Space Complexity: O(V + E) for the adjacency list and BFS queue
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] dislike : dislikes) {
            int u = dislike[0];
            int v = dislike[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // 0: uncolored, 1: group 1, -1: group 2
        int[] colors = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (colors[i] != 0) {
                continue;
            }

            Queue<Integer> queue = new LinkedList<>();
            colors[i] = 1;
            queue.offer(i);

            while (!queue.isEmpty()) {
                int curr = queue.poll();

                for (int neighbor : graph.get(curr)) {
                    if (colors[neighbor] == colors[curr]) {
                        return false;
                    }

                    if (colors[neighbor] == 0) {
                        colors[neighbor] = -colors[curr];
                        queue.offer(neighbor);
                    }
                }
            }
        }

        return true;
    }
}
