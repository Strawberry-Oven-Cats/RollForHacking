package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Hangman {

    //first making the ptui
    public static void main() throws IOException {
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
        System.out.println(solution);
        //System.out.println((int)(Math.random()*407));


    }


}




