package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Hangman {

    //first making the ptui
    public static void main(String[] args) throws IOException {
        File file =
                new File("/Users/allasophy/Documents/GitHub/RollForHacking/Hangman_words.txt");
        Scanner sc = new Scanner(file);

        //FileWriter myWriter = new FileWriter("Hangman_words.txt");
        String line;
        ArrayList<String> phrases = new ArrayList<>();

        while (sc.hasNextLine()) {
            line = sc.nextLine();
            if (line.length() != 1) {
                //line = line.split("\\[")[0];
                //myWriter.write(line + "\n")
                phrases.add(line);
                //System.out.println(line);
            }
        }
        String solution = phrases.get((int)(Math.random()*407));
        //System.out.println(solution);
        solution = solution.toLowerCase();
        //GUI(solution);
        PTUI(solution);
        //System.out.println((int)(Math.random()*407));


    }
    /***
     * THE FOLLOWING CODE IS ONLY FOR GUI
     */
    /*
    public static void GUI(String solution){
        JFrame f = new JFrame("A JFrame");
        f.setSize(250, 250);
        f.setLocation(300,200);
        final JTextArea textArea = new JTextArea(10, 40);
        f.getContentPane().add(BorderLayout.CENTER, textArea);
        final JButton button = new JButton("Click Me");
        f.getContentPane().add(BorderLayout.SOUTH, button);
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append("Button was clicked\n");

            }
        });

        f.setVisible(true);
    }
*/

    /***
     * THE FOLLOWING CODE IS ONLY FOR PTUI
     */
    public static void PTUI(String solution){
        int count = 1;
        int letters_left = 0;
        ArrayList<Boolean> rev = new ArrayList<>();
        for(int i = 0;i<solution.length();i++){
            if(solution.charAt(i) == ' '){
                rev.add(true);
            }else if(solution.charAt(i) == ',') {
                rev.add(true);
            }else if(solution.charAt(i) == '\''||(solution.charAt(i) == '.')||(solution.charAt(i) == '-')){
                rev.add(true);
            }else{
                letters_left++;
                rev.add(false);
            }
        }
        Scanner sc = new Scanner((System.in));
        //boolean done = false;

        while(letters_left>0 && count !=7){

            hang_words(solution,rev);
            System.out.println();
            System.out.println("Guess a letter");
            String letterStr = sc.next();
            char letter = letterStr.toCharArray()[0];
            if(solution.contains(letterStr)){
                for(int i = 0;i<solution.length();i++){
                    if(solution.charAt(i)==letter){
                        rev.set(i,true);
                        letters_left--;

                    }
                }

            }else{
                count++;
                System.out.println("Wrong guess, try again");
            }
            hangmanImage(count, solution);
            System.out.println();
        }
        if(letters_left==0){
            System.out.println("CONGRATS YOU WON");
        }



    }
    public static void hang_words(String solution, ArrayList<Boolean> rev){
        for(int i =0; i< solution.length();i++){
            if(rev.get(i)){
                System.out.print(solution.charAt(i));
            }else{
                System.out.print("_");
            }
            System.out.print(" ");
        }
    }
    public static void hangmanImage(int count, String solution) {
        if (count == 1) {

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("___|___");
            System.out.println();
        }
        if (count == 2) {
           // System.out.println("Wrong guess, try again");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (count == 3) {
          //  System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   | ");
            System.out.println("___|___");
        }
        if (count == 4) {
          //  System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (count == 5) {
          //  System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (count == 6) {
       //     System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |          / \\ ");
            System.out.println("___|___      /   \\");
        }
        if (count == 7) {
            System.out.println("GAME OVER!");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |          _|_");
            System.out.println("   |         / | \\");
            System.out.println("   |          / \\ ");
            System.out.println("___|___      /   \\");
            System.out.println("GAME OVER! The word was " + solution);
        }
    }


}




