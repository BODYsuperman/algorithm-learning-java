package com.alexjava.algorithms.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolveNQueens {


    public static void main(String[] args) {
        SolveNQueens solution = new SolveNQueens();

        List<List<String>> res = solution.solveNQueens(14);

        for (List<String> board : res) {
            System.out.println("一种解：");
            for (String row : board) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
    List<List<String>> res = new ArrayList<>();
    char[][] board;

    public List<List<String>> solveNQueens(int n) {

        board = new char[n][n];

        for (int i = 0; i < n ; i++) {

            Arrays.fill(board[i], '.');
        }

        dfs(n, 0);

        return res;
    }

    private void dfs(int n, int row) {

        if(row == n){
            res.add(build());
            return;
        }

      for (int col = 0; col< n;col++){
          if(!isValid(row, col, n)) continue;

          board[row][col] = 'Q';
          dfs(n, row + 1);

          board[row][col] = '.';
      }

    }

    private boolean isValid(int row, int col, int n) {
        for (int i = 0; i < row ; i++) {

            if(board[i][col] == 'Q') return false;

        }

        //left up

        for (int i = row -1, j= col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j] == 'Q') return false;
        }


        // 右上对角线 ↗
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    private List<String> build() {

        List<String> list = new ArrayList<>();

        for (char[] row: board){
            list.add(new String(row));
        }

        return list;
    }
}
