package com.company;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

/***
 *
 Make sure that dimensions are adjustable
 */

public class TicTacToe {
    public int DIM;
    public Board board;
    public Scanner in;

    public static class Board {
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

        public void add(int row, int col) throws Exception {
            if ((row < 0 || row >= DIM) || !board[row][col].equals(" ")) {
                throw new Exception("invalid");
            }
            board[row][col] = "X";
        }

        public void addComp(int row, int col) throws Exception {
            if((row < 0 || row >= DIM) || !board[row][col].equals(" ")) {
                throw new Exception("invalid");
            }
            board[row][col] = "O";
        }

        public boolean verify(){
            for (int r = 0; r < DIM; r++) {
                for(int c = 0; c < DIM; c++) {
                    if (board[r][c].equals("X")) {
                        return true;
                    }
                }
            }
            for (int c = 0; c < DIM; c++) {
                for(int r = 0; r < DIM; r++)
                if (board[c][c].equals("X")) {
                    return true;
                }
            }

            for (int r = 0; r < DIM; r++) {
                if (board[r][r].equals("X")) {
                    return true;
                }
            }
            return false;
        }

        public boolean full(){
            for (int r = 0; r < DIM; r++) {
                for (int c = 0; c < DIM; c++) {
                    if(board[r][c].equals(" ")){
                        return false;
                    }
                }
            }
            return true;
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
        in = new Scanner(System.in);
    }

    public int[] computer(){
        int r = (int)(Math.random()*(DIM+1));
        int c = (int)(Math.random()*(DIM+1));
        return new int[]{ r, c};
    }


    public void game() throws Exception {
        do{System.out.print("Pick a row and column separated by a space: ");
            String[] coordinates = in.nextLine().split(" ");
            int row = parseInt(coordinates[0]);
            int column = parseInt(coordinates[1]);
            board.add(row, column);
            int[] computer = computer();
            board.addComp(computer[0], computer[1]);
            System.out.println(board);
        }while(!board.verify() || board.full());
    }


}
