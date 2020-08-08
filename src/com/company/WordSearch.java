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
    private List<String> searchList;


    public WordSearch() throws FileNotFoundException {
        /**
         * Constructs a grid and a word list.
         */

        grid = new char[rows][cols];
        wordBank = new ArrayList<>();
        searchList = new ArrayList<>();

        File file = new File("/Users/srper/IdeaProjects/RollForHacking/WordSearch_Words.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNext()) {
            String word = sc.next();
            wordBank.add(word);
        }

        populateGrid();

    }

    public void populateGrid(){
        // create the list of 10 words to be used in the grid from the word bank
        Random rand = new Random();
        int i = 0;
        int index;

        while ( i < 10) {
            index = rand.nextInt(wordBank.size() - 1);
            // System.out.println(index + " " + wordBank.get(index) );
            searchList.add(wordBank.get(index));
            i++;
        }

        System.out.println(searchList);

    }

    public static void main(String args[]) throws FileNotFoundException {
        // create an instance of WordSearch
        // start the game and a timer
        // end the game when the user finds all the words or when the timer runs out
        WordSearch ws = new WordSearch();
    }
}
