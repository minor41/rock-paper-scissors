package com.rps;

import java.util.Random;
import java.util.Scanner;

public class GameLogic implements Move {
    Scanner sc = new Scanner(System.in);

    @Override
    public String move(String move) {
        return move;
    }

    public void newPlayersMove(String move) {
        System.out.println("Enter your move: ");
        sc.nextLine();
        if (move.equals("1") || move.equals("2") || move.equals("3")) {
            if (sc.equals("1")) move.equals(new Rock("Rock"));
            if (sc.equals("2")) move.equals(new Paper("Paper"));
            if (sc.equals("3")) move.equals(new Scissors("Scissors"));
        }
    }
    public void newComputersMove(String move) {
        Random random = new Random();
        int r = random.nextInt(3)+1;
        if (r == 1) move.equals(new Rock("Rock"));
        if (r == 2) move.equals(new Paper("Paper"));
        if (r == 3) move.equals(new Scissors("Scissors"));
    }

}
