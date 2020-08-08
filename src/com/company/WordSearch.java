package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WordSearch {
    private final int rows = 20, cols = 20;
    private char[][] grid;
    private List<String> wordBank;
    private List<String> searchList;


    public WordSearch() throws FileNotFoundException {
        /**
         * Constructs a word bank from a text file.
         * Generates a list of 10 random words from the word bank to search for.
         */

        grid = new char[rows][cols];
        for (int y = 0; y < cols; y++) {
            for (int x = 0; x < rows; x++) {
                grid[x][y] = '_';
            }
        }

        wordBank = new ArrayList<>();
        searchList = new ArrayList<>();

        File file = new File("/Users/srper/IdeaProjects/RollForHacking/WordSearch_Words.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNext()) {
            String word = sc.next();
            wordBank.add(word);
        }

        // create the list of 10 words to be used in the grid from the word bank
        int i = 0;
        int index;
        Random rand = new Random();

        while ( i < 10) {
            index = rand.nextInt(wordBank.size() - 1);
            // System.out.println(index + " " + wordBank.get(index) );
            searchList.add(wordBank.get(index));
            i++;
        }

        // populate the grid with the words in the list
        populateGrid();

    }

    public void populateGrid(){
        // add each word to the grid
        for (int i = 0; i < searchList.size(); i++) {
            String curWord = searchList.get(i);
            int curWordLength = curWord.length();
            System.out.println("word: " + curWord + " length: " + curWordLength);
            if ( i % 2 == 0) { // if its even, try to add it horizontally
                // generate random coordinate
                Random rand = new Random();
                int xcoor = rand.nextInt(rows);
                int ycoor = rand.nextInt(cols);

                // check that x coordinate + length of word < rows
                while ( xcoor + curWordLength > rows) {
                    xcoor = rand.nextInt(rows);
                }

                System.out.println("coordinates x: " + xcoor + " y: " + ycoor);

                // print the word into the grid
                for (int letterIndex = 0; letterIndex < curWordLength; letterIndex++) {
                    grid[xcoor][ycoor] = curWord.charAt(letterIndex);
                    xcoor++;
                    printGrid();
                    System.out.println();
                }

            } else { // try to add it vertically
                // generate random coordinate
                Random rand = new Random();
                int xcoor = rand.nextInt(rows);
                int ycoor = rand.nextInt(cols);

                // check that y coordinate + length of word < cols
                while ( ycoor + curWordLength > cols) {
                    ycoor = rand.nextInt(cols);
                }

                System.out.println("coordinates x: " + xcoor + " y: " + ycoor);
                // print the word into the grid
                for (int letterIndex = 0; letterIndex < curWordLength; letterIndex++) {
                    grid[xcoor][ycoor] = curWord.charAt(letterIndex);
                    ycoor++;
                    printGrid();
                    System.out.println();
                }
            }

        }


    }

    public void printGrid() {
        // prints the grid
        // currently only prints dummy data - underscores
        for (int y = 0; y < cols; y++) {
            for (int x = 0; x < rows; x++) {
                System.out.print(grid[x][y] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) throws FileNotFoundException {
        // create an instance of WordSearch
        // start the game and a timer
        // end the game when the user finds all the words or when the timer runs out
        WordSearch ws = new WordSearch();
        System.out.println("Look for: " + ws.searchList);
        ws.printGrid();
    }
}
