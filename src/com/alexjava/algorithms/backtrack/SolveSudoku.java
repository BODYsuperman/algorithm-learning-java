package com.alexjava.algorithms.backtrack;

public class SolveSudoku {



    public void solveSudoku(char[][] board) {
        dfs(board);
    }

    private boolean dfs(char[][] board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (board[i][j] != '.') continue;

                for (char c = '1'; c <= '9'; c++) {

                    if (!isValid(board, i, j, c)) continue;

                    board[i][j] = c;

                    if (dfs(board)) return true;

                    board[i][j] = '.'; // 回溯
                }

                return false; // 1~9都不行
            }
        }

        return true; // 全填完
    }

    private boolean isValid(char[][] board, int row, int col, char c) {

        for (int i = 0; i < 9; i++) {

            // 行
            if (board[row][i] == c) return false;

            // 列
            if (board[i][col] == c) return false;

            // 3x3 宫
            int r = (row / 3) * 3 + i / 3;
            int cc = (col / 3) * 3 + i % 3;

            if (board[r][cc] == c) return false;
        }

        return true;
    }
}
