package com.rps;

import java.util.Scanner;

public class GameRules {
    public String user;
    public int roundsCount;

    public void setTheGame() {

        Scanner inputData = new Scanner(System.in);

        System.out.println("Shall we play this game...?\n");
        System.out.println("Please write your name and press ENTER");
        user = inputData.next();
        System.out.println("welcome " + user + " to the Rock-Paper-Scissors! \n");
        System.out.println("                ENJOY! \n");
    }
}
