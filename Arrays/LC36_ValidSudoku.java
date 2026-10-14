/*
 * LeetCode 36 - Valid Sudoku
 *
 * Difficulty: Medium
 * Topic: Arrays, Hash Table, Matrix
 *
 * Approach:
 * - Use boolean arrays or bit masks / hash sets to track seen numbers (1-9) in each row, column, and 3x3 box.
 * - Iterate through each cell in the 9x9 board; skip '.'.
 * - If a digit has already appeared in the same row, column, or sub-box, return false.
 *
 * Time Complexity: O(1) - fixed 9x9 board (81 cells)
 * Space Complexity: O(1) - fixed tracking tables
 */

import java.util.*;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') continue;

                int val = board[r][c] - '1';
                int boxIndex = (r / 3) * 3 + (c / 3);

                if (rows[r][val] || cols[c][val] || boxes[boxIndex][val]) {
                    return false;
                }

                rows[r][val] = true;
                cols[c][val] = true;
                boxes[boxIndex][val] = true;
            }
        }

        return true;
    }
}
