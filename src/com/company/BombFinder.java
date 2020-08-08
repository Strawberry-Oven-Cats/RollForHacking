package com.company;

public class BombFinder {

    public static class board {
        //fields
        int tot_bombs = 0;
        int[] bombs_col = {0, 0, 0, 0, 0};
        int[] bombs_row = {0, 0, 0, 0, 0};
        int[][] board = {{0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}};
        int DIM = 5;
        int percent_chance = ((int) (Math.random() * 50)) + 25;

        //constructors
        public board() {
            for (int i = 0; i < DIM; i++) {
                for (int j = 0; j < DIM; j++) {
                    if ((Math.random() * 100) <= percent_chance) {
                        tot_bombs++;
                        bombs_col[j]++;
                        bombs_row[i]++;
                        board[i][j] = 1;
                    }
                }


            }
        }

        //methods
        public void print_board() {
            System.out.print("  | ");
            for(int i = 1; i<=DIM; i++){
                System.out.print(i+" ");
            }
            System.out.println();
            System.out.println("  |----------");
            System.out.print("  | ");
            for (int c = 0; c < DIM; c++) {
                System.out.print(bombs_col[c]+" ");
            }
            System.out.println();
            System.out.println("  |----------");
            for (int i = 0; i < DIM; i++) {
                System.out.print(bombs_row[i]+" | ");
                for (int j = 0; j < DIM; j++) {

                }
                System.out.println();
            }
        }
    }
    public static void main(String[] args){
        board myBoard = new board();
        myBoard.print_board();
    }




}
