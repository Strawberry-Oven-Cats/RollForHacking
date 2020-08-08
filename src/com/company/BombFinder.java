package com.company;

import java.util.Scanner;

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
        int[][] rev = {{0, 0, 0, 0, 0},
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
            System.out.print("      | ");
            for(int i = 1; i<=DIM; i++){
                System.out.print(i+" ");
            }
            System.out.println();
            System.out.println("      |----------");
            System.out.print("      | ");
            for (int c = 0; c < DIM; c++) {
                System.out.print(bombs_col[c]+" ");
            }
            System.out.println();
            System.out.println("      |----------");
            for (int i = 0; i < DIM; i++) {
                System.out.print((i+1)+" | "+bombs_row[i]+" | ");
                for (int j = 0; j < DIM; j++) {
                    if(rev[i][j]==0){
                        System.out.print("? ");
                    }else{
                        if(board[i][j] == 1){
                            System.out.print("X ");
                        }else {
                            System.out.print("0 ");
                        }
                    }
                }
                System.out.println();
            }
        }
    }
    public static void main(String[] args){
        board myBoard = new board();
        myBoard.print_board();
        int left = 25-myBoard.tot_bombs;
        boolean gameover= false;
        int x = 0;
        int y = 0;
        Scanner sc = new Scanner(System.in);
        while(!gameover&&left>0){
            boolean valid = false;
            while(!valid){
                System.out.println("ENTER A GUESS 'x,y'");
                String[] str = sc.next().split(",");
                x = Integer.parseInt(str[0])-1;
                y = Integer.parseInt(str[1])-1;
                if(myBoard.rev[x][y] == 0){
                    valid = true;
                }
            }
            myBoard.rev[x][y] = 1;
            if(myBoard.board[x][y] == 0) {
                gameover = true;
                System.out.println("THATS NOT A BOMB :( GAME OVER!!!!");
            }else{

                left--;
            }
            myBoard.print_board();

        }
        if(left == 0){
            System.out.println("CONGRATS YOU WON!!!!!");
        }
    }




}
