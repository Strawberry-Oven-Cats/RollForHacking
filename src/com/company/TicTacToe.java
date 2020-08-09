package com.company;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

/***
 *
 Make sure that dimensions are adjustable
 */

public class TicTacToe {

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
            board[row][col] = "O";
        }

        public boolean verify(){
            for (int r = 0; r < DIM; r++) {
                boolean win = true;
                for(int c = 0; c < DIM; c++) {
                    if(!board[r][c].equals("X")) {
                        win = false;
                    }
                }
                if(win){
                    return true;
                }
            }

            for (int c = 0; c < DIM; c++) {
                boolean win = true;
                for(int r = 0; r < DIM; r++) {
                    if (!board[r][c].equals("X")) {
                        win = false;
                    }
                }
                if (win) {
                    return true;
                }
            }

            boolean win = true;
            for (int r = 0; r < DIM; r++) {
                if (!board[r][r].equals("X")) {
                    win = false;
                }
            }
            if(win){
                return true;
            }

            boolean win1 = true;
            for (int r = 0; r < DIM; r++) {
                if (!board[r][DIM-1-r].equals("X")) {
                    win1 = false;
                }
            }
            if(win1){
                return true;
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

        public String card(int row, int column){
            return board[row][column];
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
        Random r = new Random();
        int row = r.nextInt(board.DIM);
        Random c = new Random();
        int column = c.nextInt(board.DIM);
        if(!board.card(row, column).equals(" ")) {
            while (!board.card(row, column).equals(" ")) {
                row = r.nextInt(board.DIM );
                column = c.nextInt(board.DIM);
            }
        }
        return new int[]{row, column};
    }


    public boolean game() throws Exception {
        System.out.println(board);
        do{System.out.print("Pick a row and column separated by a space: ");
            String[] coordinates = in.nextLine().split(" ");
            int row = parseInt(coordinates[0]);
            int column = parseInt(coordinates[1]);
            board.add(row, column);
            int[] computer = computer();
            board.addComp(computer[0], computer[1]);
            System.out.println(board);
        }while(!board.verify() && !board.full());

        if(board.verify()){
            System.out.println("Winner!!");
            return true;
        }
        else {
            System.out.println("LOSER :(");
            return false;
        }
    }


}
