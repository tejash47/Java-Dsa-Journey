/*
 * LeetCode 79 - Word Search
 *
 * Difficulty: Medium
 * Topic: Array, Backtracking, Matrix
 *
 * Approach:
 * - Use DFS backtracking starting from every cell matching word[0].
 * - Mark visited cells by temporarily modifying character, then restore on backtrack.
 * - Return true if all characters are matched in 4-directional traversal.
 *
 * Time Complexity: O(m * n * 3^L), where L is word length
 * Space Complexity: O(L) recursion stack
 */

class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int idx) {
        if (idx == word.length()) return true;
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(idx)) {
            return false;
        }

        char temp = board[r][c];
        board[r][c] = '#'; // Mark visited

        boolean found = dfs(board, word, r + 1, c, idx + 1) ||
                        dfs(board, word, r - 1, c, idx + 1) ||
                        dfs(board, word, r, c + 1, idx + 1) ||
                        dfs(board, word, r, c - 1, idx + 1);

        board[r][c] = temp; // Backtrack
        return found;
    }
}
