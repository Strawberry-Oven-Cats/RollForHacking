package com.company;

import java.io.IOException;

public class Story {
    public static void main(String[] args) throws IOException {
        int loss = 0;
        System.out.println("You: I'm tired of feeling like this. I'm so miserable but there's nothing I can do\n" +
                           "???: Hello.\n" +
                           "You: Huh? Who are you?\n" +
                           "???: I am who you aspire to be, an ideal version of yourself, you can call me I.\n" +
                           "You: What are you doing here inside of my head?\n" +
                           "I: I am here to guide you.\n" +
                           "You: How? What can you do?\n" +
                           "I: We are going to tackle your emotions. Firstly, sadness. Let's play a game of tic tac toe, shall we?\n");

/*
        while(true){
            if(TicTacToe.game()){
                System.out.println("I: Well done. In a game like this, someone has to lose, and possibly get sad. It" +
                        "becomes their job to accept it. It is the same as life, not everybody can be the winner. " +
                        "Acceptance is the first step in moving on.");
                break;
            } else {
                System.out.println("I: Failure is part of the journey. Try again.");
                loss++;
            }

            if(loss == 3){
                System.out.println("I: Acceptance is important when it comes to dealing with sadness. You may have lost" +
                        "today, but you can always try again another day. You could also just move on, it is only a game" +
                        "of tic tac toe after all.");
                break;
            }
        }
        */
        loss = 0;
        System.out.println("You: Why does that matter? Even if I move on, I still hate myself for all the things I've done\n." +
                "I: That brings us to disgust. It is also contributes to your sadness.\n" +
                "You: Maybe you are right, but what can I do? I simply do not like myself.\n" +
                "I: Ask yourself why you dislike yourself, let's play a game of hangman while you're at it.\n");

        while(true){
            if(Hangman.game()){
                System.out.println("I: I didn't expect anybody to guess that. Maybe you aren't as bad as you think you" +
                        " are.\n" +
                        "You: How about that one really embarassing moment during my first date, or that time I made" +
                        "a fool out of myself at my 13th birthday party.\n" +
                        "I: Dwelling on little awkward moments like those will only make you feel worse. Chances are," +
                        " nobody even remembers those moments. Everybody, like you, is focused on their own moments.");
                break;
            } else {
                System.out.println("I: That's okay, you can try again.");
            }
        }

        System.out.println("You: Enough games. I'm tired of this. Get out of my head.\n" +
                "???: Ah, anger. Perhaps from pent up frustration or stress.\n" +
                "You: Enough!\n" +
                "???: Letting yourself get consumed by anger is dangerous. Why don't we settle down and play some word search?\n");

        //word search
    }
}
