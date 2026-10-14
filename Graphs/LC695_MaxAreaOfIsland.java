/*
 * LeetCode 695 - Max Area of Island
 *
 * Difficulty: Medium
 * Topic: Array, Depth-First Search, Breadth-First Search, Union Find, Matrix
 *
 * Approach:
 * - Iterate through grid; for each cell with 1, run DFS to calculate island area.
 * - Mark visited land cells by setting them to 0.
 * - Track the maximum area encountered.
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n) recursion stack worst-case
 */

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) {
            return 0;
        }

        grid[r][c] = 0; // Mark visited
        int area = 1;

        area += dfs(grid, r + 1, c);
        area += dfs(grid, r - 1, c);
        area += dfs(grid, r, c + 1);
        area += dfs(grid, r, c - 1);

        return area;
    }
}
