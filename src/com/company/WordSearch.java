package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WordSearch {
    private final int rows = 10, cols = 10;
    private char[][] grid;
    private List<String> wordBank;

    public WordSearch() throws FileNotFoundException {
        /**
         * Constructs a grid and a word list.
         */

        grid = new char[rows][cols];
        wordBank = new ArrayList<>();

        File file = new File("/Users/srper/IdeaProjects/RollForHacking/WordSearch_Words.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNext()) {
            String word = sc.next();
            wordBank.add(word);
            System.out.println(wordBank);
        }



    }

    public static void main(String args[]) throws FileNotFoundException {
        // create an instance of WordSearch
        // start the game and a timer
        // end the game when the user finds all the words or when the timer runs out
        WordSearch ws = new WordSearch();
    }
}
