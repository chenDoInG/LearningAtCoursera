package com.chendoing.leetcode;

import org.junit.Test;

/**
 * Determine if a Sudoku is valid, according to: <a link="http://sudoku.com.au/TheRules.aspx">Sudoku Puzzles - The Rules</>.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 */
public class ValidSudoku {

    /**
     * 用3个变量row/col/block分别记录横列,竖列和块里是否数独
     * 用二进制与或运算来判断每个横列,竖列和块里的数是否重复
     * 举例: 如果第一行重复出现两个2,(1<<1&1<<1 = 2) != 0 不是数独
     *      如果第一行出现1-9所有数字,(1<<0&1<<1&...&1<<9 = 0) 是数独
     * @param board 数独
     * @return true ? false 是否数独
     */
    public boolean isValidSudoku(char[][] board) {

        if (board == null)
            throw new NullPointerException();

        for (int i = 0; i < 9; i++) {
            int row = 0;
            int col = 0;
            int block = 0;
            for (int j = 0; j < 9; j++) {
                int rowValue = board[i][j] - '1';
                int colValue = board[j][i] - '1';
                int blockValue = board[i / 3 * 3 + j / 3][i % 3 * 3 + j % 3] - '1';
                if (rowValue >= 0 && (row & (1 << rowValue)) != 0
                        || colValue >= 0 && (col & (1 << colValue)) != 0
                        || blockValue >= 0 && (block & (1 << blockValue)) != 0)
                    return false;
                row |= rowValue >= 0 ? 1 << rowValue : 0;
                col |= colValue >= 0 ? 1 << colValue : 0;
                block |= blockValue >= 0 ? 1 << blockValue : 0;
            }
        }
        return true;
    }

    @Test
    public void isValidSudoku() {
        System.out.print(isValidSudoku(new char[][]{
                {'5', '3', '4', '2', '7', '6', '1', '9', '8'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '3', '4', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '5', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '3', '.', '2', '8', '.'},
                {'.', '7', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        }));
    }
}
