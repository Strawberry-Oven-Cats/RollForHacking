package com.company;

import java.io.IOException;

public class Story {
    public static void main(String[] args) throws IOException {
        int loss = 0;
        System.out.println("You: I'm tired of feeling like this. Life is so miserable but there's nothing I can do about it.\n" +
                           "???: Hello.\n" +
                           "You: Huh? Who are you?\n" +
                           "???: I am who you aspire to be, an ideal version of yourself, you can call me I.\n" +
                           "You: What are you doing here inside of my head?\n" +
                           "I: I am here to guide you.\n" +
                           "You: What for?\n" +
                           "I: We are going to tackle your emotions, and I'll help you through it. Things aren't always as" +
                           "bad as they appear to be. Firstly, sadness. Let's play a game of tic tac toe, shall we?\n");

/* FIX1
        while(true){
            if(TicTacToe.game()){
                System.out.println("I: Well done. In a game like this, someone has to lose. It" +
                        "becomes their job to accept it. It is the same as life, not everybody can be the winner. " +
                        "Acceptance is the first step in moving on.");
                break;
            } else {
                System.out.println("I: Failure is part of the journey. Try again.");
                loss++;
            }

            if(loss == 3){
                System.out.println("I: Acceptance is important when it comes to dealing with sadness. You may have lost" +
                        "today, but you can always try again another day. You could also just move on and focus on other things.");
                break;
            }
        }
        */

        System.out.println("You: Why does that matter? Even if I move on, I still hate myself for all the things I've done.\n" +
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
                        " nobody even remembers them. Everybody, like you, is focused on their own encounters.");
                break;
            } else {
                System.out.println("I: Close, try again.");
            }
        }

        System.out.println("You: Enough games. I'm tired of this. Get out of my head.\n" +
                "I: Ah, anger. Perhaps from pent up frustration or stress.\n" +
                "You: Enough!\n" +
                "I: Letting yourself get consumed be anger is dangerous. Why don't we settle down and play some word search?\n");


        /* FIX2
        while(true){
            if (WordSearch.game()) {
                System.out.println("I: I hope that was relaxing, it was for me, at least. Everybody get angry at times, " +
                                   "but letting it get to your head may be devastating. It may cloud your visions and " +
                                   " cause you to act irrationally. If someone has done you wrong, figure out why and " +
                                   "try to forgive.");
            } else {
                //for if wordsearch becomes loseable
            }
        }
        */

        System.out.println("You: ...\n" +
                "I: How are you feeling?\n" +
                "You: My emotions are a mess! I'm afraid of all these feelings.\n" +
                "I: It is normal for people to fear the unknown. Before that, let's play one last game.\n");
        loss = 0;
        while(true){
            if (BombFinder.game()) {
                System.out.println("I: Nicely done. At the beginning, certain things may appear to be overwhelming" +
                                   ", but as you begin to understand more of it, fear and uncertainty will disappear." +
                                   " The same could be said for your emotions. Once you conquer your feelings, you will" +
                                   " realize that it is okay to be confused and stuck at times.");
                break;
            } else {
                loss++;
            }

            if(loss==3){
                System.out.println("I: It is okay to fail. You can always return and conquer it another day, just like" +
                                   " your emotions. You may be afraid of them right now, but you have all the time " +
                                   "you need to understand yourself.");
                break;
            }
        }

        System.out.println("I: Let me give you one final advice, constant happiness is impossible. Certain people" +
                           " may experience them more than others, but a day will still come where they must face sorrow." +
                           "A balance of emotions in your life will help you be more prepared for the road ahead. Remember" +
                           " that you are not alone, and can confide in friends, but at the end you must be the one to conquer" +
                           " your own feelings");
    }
}
