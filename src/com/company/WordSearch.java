package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WordSearch {
    private final int rows = 15, cols = 15;
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

        while ( i < 5) {
            index = rand.nextInt(wordBank.size() - 1);
            // System.out.println(index + " " + wordBank.get(index) );
            searchList.add(wordBank.get(index));
            i++;
        }

        // populate the grid with the words in the list
        populateGrid();

    }

    public void populateGrid() {
        // add each word to the grid
        for (int i = 0; i < searchList.size(); i++) {
            String curWord = searchList.get(i);
            int curWordLength = curWord.length();
            System.out.println("word: " + curWord + " length: " + curWordLength);
            if ( i % 2 == 0) { // if its even, try to add it horizontally
                // generate random coordinates until you find a valid pair
                boolean isValid = false;
                Random rand = new Random();
                int xcoor = 0, ycoor = 0;

                while (!isValid) {
                    xcoor = rand.nextInt(rows);
                    ycoor = rand.nextInt(cols);
                    System.out.println("coordinates x: " + xcoor + " y: " + ycoor);

                    // check that x coordinate + length of word < rows AND that we don't overwrite any other words
                    if (xcoor + curWordLength <= rows && checkCoordinateValidity(xcoor, ycoor, curWordLength, true)) {
                        isValid = true;
                    }
                }

                // write the word into the grid
                int letterIndex;
                for (letterIndex = 0; letterIndex < curWordLength; letterIndex++) {
                    grid[xcoor][ycoor] = curWord.charAt(letterIndex);
                    xcoor++;
                    printGrid();
                    System.out.println();
                }
            } else { // try to add it vertically
                // generate random coordinates until you find a valid pair
                boolean isValid = false;
                Random rand = new Random();
                int xcoor = 0, ycoor = 0;

                while (!isValid) {
                    xcoor = rand.nextInt(rows);
                    ycoor = rand.nextInt(cols);
                    System.out.println("coordinates x: " + xcoor + " y: " + ycoor);

                    // check that y coordinate + length of word < cols AND that we don't overwrite any other words
                    if (ycoor + curWordLength <= cols && checkCoordinateValidity(xcoor, ycoor, curWordLength, false)) {
                        isValid = true;
                    }
                }
                // write the word into the grid
                int letterIndex;
                for (letterIndex = 0; letterIndex < curWordLength; letterIndex++) {
                    grid[xcoor][ycoor] = curWord.charAt(letterIndex);
                    ycoor++;
                    printGrid();
                    System.out.println();
                }
            }
        }

        // fill in each free space with a random char!

    }

    public boolean checkCoordinateValidity(int xcoor, int ycoor, int wordLength, boolean horizontal){
        if (horizontal) {
            for (int cur = xcoor; cur < xcoor + wordLength; cur++) {
                if (grid[cur][ycoor] != '_') {
                    return false;
                }
            }
        } else {
            for (int cur = ycoor; cur < ycoor + wordLength; cur++) {
                if (grid[xcoor][cur] != '_') {
                    return false;
                }
            }
        }
        return true;
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
