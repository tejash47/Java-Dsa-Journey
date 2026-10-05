/*
 * LeetCode 130 - Surrounded Regions
 *
 * Difficulty: Medium
 * Topic: Graph, DFS, Flood Fill, Matrix
 *
 * Approach:
 * - Any 'O' connected to the boundary cannot be surrounded.
 * - Start DFS from every boundary 'O' and mark it as safe.
 * - Convert all remaining 'O' cells to 'X'.
 * - Convert the temporary safe marker back to 'O'.
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */

class Solution {

    public void solve(char[][] board) {

        if (board == null || board.length == 0) {
            return;
        }

        int rows = board.length;
        int cols = board[0].length;

        // Process first and last columns
        for (int row = 0; row < rows; row++) {
            dfs(board, row, 0);
            dfs(board, row, cols - 1);
        }

        // Process first and last rows
        for (int col = 0; col < cols; col++) {
            dfs(board, 0, col);
            dfs(board, rows - 1, col);
        }

        // Convert surrounded O's to X
        // and restore safe O's
        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {

                if (board[row][col] == 'O') {
                    board[row][col] = 'X';
                } else if (board[row][col] == '#') {
                    board[row][col] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {

        int rows = board.length;
        int cols = board[0].length;

        if (row < 0 || row >= rows ||
            col < 0 || col >= cols ||
            board[row][col] != 'O') {
            return;
        }

        // Mark boundary-connected O as safe
        board[row][col] = '#';

        dfs(board, row + 1, col);
        dfs(board, row - 1, col);
        dfs(board, row, col + 1);
        dfs(board, row, col - 1);
    }
}