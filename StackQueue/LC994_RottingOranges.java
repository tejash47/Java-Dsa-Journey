/*
 * LeetCode 994 - Rotting Oranges
 *
 * Difficulty: Medium
 * Topic: Queue, BFS, Matrix
 *
 * Approach:
 * - Add all initially rotten oranges to a queue.
 * - Process the queue level by level.
 * - Each minute, rotten oranges infect adjacent fresh oranges.
 * - Count the number of fresh oranges remaining.
 * - Return the elapsed time if all oranges become rotten.
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */

import java.util.*;

class Solution {

    public int orangesRotting(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        int fresh = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int minutes = 0;

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!queue.isEmpty() && fresh > 0) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                int[] current = queue.poll();

                for (int[] direction : directions) {

                    int row = current[0] + direction[0];
                    int col = current[1] + direction[1];

                    if (row >= 0 && row < rows &&
                        col >= 0 && col < cols &&
                        grid[row][col] == 1) {

                        grid[row][col] = 2;
                        fresh--;

                        queue.offer(new int[]{row, col});
                    }
                }
            }

            minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}