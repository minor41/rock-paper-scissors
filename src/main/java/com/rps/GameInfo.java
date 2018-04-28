package com.rps;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameInfo {
    public String user;
    public int roundsCount;
    Scanner inputData = new Scanner(System.in);

    public void setTheGame() {
        System.out.println("Shall we play this game...?");
        System.out.println("Please write your name and press ENTER");
        user = inputData.nextLine();
        System.out.println("welcome " + user + " to the Rock-Paper-Scissors!");
        System.out.println("                ENJOY! \n");
        System.out.println("If you like to play best out of Three press 3\n" +
                "or if you like to play best out of Five press 5 ??\n" +
                "then press Enter:");
        roundsCount = inputData.nextInt();
        try {
            if (roundsCount == 3 || roundsCount == 5) {
                System.out.println("Let's start the game:\n");
            } else {
                System.out.println("Please enter 3 or 5 for the correct game");
            }
        } catch (InputMismatchException e) {

        }
    }

    public void keysInfo() {
        System.out.println("Game Rules:\n" +
                "Press 1 --> ROCK\n" +
                "Press 2 --> PAPER\n" +
                "Press 3 --> SCISSORS\n" +
                "Press x --> Finish the Game!\n" +
                "Press n --> New Game!\n\n" +
                "Now Let's Begin!");
    }
}
