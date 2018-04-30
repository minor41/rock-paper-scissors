package com.rps;

import java.util.Random;
import java.util.Scanner;

public class GameLogic {
    private Scanner sc = new Scanner(System.in);
    private GameScore gameScore;

    public GameLogic(GameScore gameScore) {
        this.gameScore = gameScore;
    }

    public void newPlayersMove(String playerMove) throws InvalidMoveException {
        System.out.println("Your move: ");
        sc.nextLine();
        if (playerMove.equals("1") || playerMove.equals("2") || playerMove.equals("3")) {
            if (playerMove.equals("1")) gameScore.setPlayerMove(new Rock());
            if (playerMove.equals("2")) gameScore.setPlayerMove(new Paper());
            if (playerMove.equals("3")) gameScore.setPlayerMove(new Scissors());
        } else {
            throw new InvalidMoveException();
        }
    }

    public void newComputerMove() {
        Random random = new Random();
        int r = random.nextInt(3) + 1;
        if (r == 1) gameScore.setComputerMove(new Rock());
        if (r == 2) gameScore.setComputerMove(new Paper());
        if (r == 3) gameScore.setComputerMove(new Scissors());
        System.out.println("Computer chose " + r);
    }

    public void results(Move playerMove, Move computerMove) {
        if (playerMove.equals(computerMove)) {
            System.out.println("It'a tie! Next Round");
        }
        if (playerMove.equals(new Rock())) {
            if (computerMove.equals(new Scissors())) {
                gameScore.setUserPoints(gameScore.getUserPoints() + 1);
                System.out.println("Rock beats Scissors: " + gameScore.getUser() + " wins this round");
            }
            if (computerMove.equals(new Paper())) {
                gameScore.setComputerPoints(gameScore.getComputerPoints() + 1);
                System.out.println("Paper beats Rock: computer wins this round");
            }
        }
        if (playerMove.equals(new Paper())) {
            if (computerMove.equals(new Rock())) {
                gameScore.setUserPoints(gameScore.getUserPoints() + 1);
                System.out.println("Paper beats Rock: " + gameScore.getUser() + " win this round");
            }
            if (computerMove.equals(new Scissors())) {
                gameScore.setComputerPoints(gameScore.getComputerPoints() + 1);
                System.out.println("Scissors beat Paper: computer wins this round");
            }
        }
        if (playerMove.equals(new Scissors())) {
            if (computerMove.equals(new Paper())) {
                gameScore.setUserPoints(gameScore.getUserPoints() + 1);
                System.out.println("Scissors beat Paper: " + gameScore.getUser() + " wins this round");
            }
            if (computerMove.equals(new Rock())) {
                gameScore.setComputerPoints(gameScore.getComputerPoints() + 1);
                System.out.println("Rock beats Scissors: computer wins this round");
            }
        }
    }


}
