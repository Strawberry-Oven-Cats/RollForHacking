package com.company;

/***
 *
 Make sure that dimensions are adjustable
 */

public class TicTacToe {
    public int DIM;
    public Board board;

    public class Board {
        private String[][] board;
        private int DIM;

        public Board(int DIM) {
            this.DIM = DIM;
            this.board = new String[DIM][DIM];
            for (int r = 0; r < DIM; r++) {
                for (int c = 0; c < DIM; c++) {
                    board[r][c] = " ";
                }
            }
        }

        public void Add(int row, int col) throws Exception {
            if (row < 0 || row >= DIM) {
                throw new Exception("invalid");
            }
            board[row][col] = "X";
        }

        @Override
        public String toString() {
            StringBuilder str = new StringBuilder();
            // build the top row of indices
            str.append("  ");
            for (int col = 0; col < this.DIM; ++col) {
                str.append(col);
            }
            str.append("\n");
            // build each row of the actual board
            for (int row = 0; row < this.DIM; ++row) {
                str.append(row).append("|");
                // build the columns of the board
                for (int col = 0; col < this.DIM; ++col) {
                    str.append(this.board[row][col]);
                }
                str.append("\n");
            }
            return str.toString();
        }
    }

    public TicTacToe(int DIM){
        board = new Board(DIM);
    }

    public void game(){

    }



}
