package com.rps;

import java.util.Scanner;

public class GameInfo {
    private String user;
    private int roundsCount;
    private Scanner inputData = new Scanner(System.in);

    public void setTheGame() {
        System.out.println("Shall we play this game...?");
        System.out.println("Please write your name and press ENTER");
        user = inputData.nextLine();
        System.out.println("welcome " + user + " to the Rock-Paper-Scissors!");
        System.out.println("                ENJOY! \n");
        System.out.println("Please enter the number of rounds you would like to play...?");
        roundsCount = inputData.nextInt();
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
