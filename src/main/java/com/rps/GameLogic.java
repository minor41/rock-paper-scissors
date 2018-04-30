package com.rps;

import java.util.Random;
import java.util.Scanner;

public class GameLogic {
    private Scanner sc = new Scanner(System.in);
    private GameScore gameScore;
    private GameInfo gameInfo;
    private int wins = 0;
    private int loses = 0;

    public GameLogic(GameScore gameScore, GameInfo gameInfo) {
        this.gameInfo = gameInfo;
        this.gameScore = gameScore;
    }

    private GameScore getGameScore() {
        return gameScore;
    }

    private String newMove() {
        System.out.println("Your Move: ");
        return sc.nextLine();
    }

    private void newPlayersMove(String playerMove) throws InvalidMoveException {
        if (playerMove.equals("1") || playerMove.equals("2") || playerMove.equals("3")) {
            if (playerMove.equals("1")) gameScore.setPlayerMove(new Rock());
            if (playerMove.equals("2")) gameScore.setPlayerMove(new Paper());
            if (playerMove.equals("3")) gameScore.setPlayerMove(new Scissors());
        } else {
            throw new InvalidMoveException();
        }
    }

    private void newComputerMove() {
        Random random = new Random();
        int r = random.nextInt(3) + 1;
        if (r == 1) gameScore.setComputerMove(new Rock());
        if (r == 2) gameScore.setComputerMove(new Paper());
        if (r == 3) gameScore.setComputerMove(new Scissors());
        System.out.println("Computer chose " + r);
    }

    private void results(Move playerMove, Move computerMove) {
        if (playerMove.equals(computerMove)) {
            System.out.println("It'a tie! Next Round \n");
        }
        if (playerMove.equals(new Rock())) {
            if (computerMove.equals(new Scissors())) {
                gameScore.setUserPoints(gameScore.getUserPoints() + 1);
                System.out.println("Rock beats Scissors: " + gameScore.getUser() + " wins this round \n");
            }
            if (computerMove.equals(new Paper())) {
                gameScore.setComputerPoints(gameScore.getComputerPoints() + 1);
                System.out.println("Paper beats Rock: computer wins this round \n");
            }
        }
        if (playerMove.equals(new Paper())) {
            if (computerMove.equals(new Rock())) {
                gameScore.setUserPoints(gameScore.getUserPoints() + 1);
                System.out.println("Paper beats Rock: " + gameScore.getUser() + " win this round \n");
            }
            if (computerMove.equals(new Scissors())) {
                gameScore.setComputerPoints(gameScore.getComputerPoints() + 1);
                System.out.println("Scissors beat Paper: computer wins this round \n");
            }
        }
        if (playerMove.equals(new Scissors())) {
            if (computerMove.equals(new Paper())) {
                gameScore.setUserPoints(gameScore.getUserPoints() + 1);
                System.out.println("Scissors beat Paper: " + gameScore.getUser() + " wins this round \n");
            }
            if (computerMove.equals(new Rock())) {
                gameScore.setComputerPoints(gameScore.getComputerPoints() + 1);
                System.out.println("Rock beats Scissors: computer wins this round \n");
            }
        }
    }

    public void gameLogic() {
        gameLogic(gameScore.getRoundsCount());
    }

    public void gameLogic(int roundsCount) {
        boolean endGame = false;
        while (!endGame) {
            if (gameScore.getComputerPoints() == roundsCount || gameScore.getUserPoints() == roundsCount) {
                return;
            }
            System.out.println(gameScore);
            String move = newMove();
            while (move.equals("n")) {
                System.out.println("are you sure you want to start new game? (y/n)");
                String options = sc.nextLine();
                if (options.equals("y")) {
                    gameInfo.setTheGame();
                } else {
                    move = newMove();
                }
            }
            while (move.equals("x")) {
                System.out.println("Are you sure you want to quit? (y/n)");
                String options = sc.nextLine();
                if (options.equals("y")) {
                    System.exit(0);
                } else {
                    move = newMove();
                }
            }
            newComputerMove();
            boolean validMove = false;
            while (!validMove) {
                try {
                    newPlayersMove(move);
                    validMove = true;
                } catch (InvalidMoveException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Wrong value! Please do it again: ");
                    move = sc.nextLine();
                }
            }
            results(getGameScore().getPlayerMove(), getGameScore().getComputerMove());
        }
    }

    public void gameMessage() {
        if (gameScore.getComputerPoints() > gameScore.getUserPoints()) {
            System.out.println(gameScore);
            System.out.println("Computer won the whole match\n" + gameScore.getComputerPoints() + " : " +
                    gameScore.getUserPoints());
            loses++;
        } else if (gameScore.getUserPoints() > gameScore.getComputerPoints()) {
            System.out.println(gameScore);
            System.out.println(gameScore.getUser() + " won the whole match\n" + gameScore.getComputerPoints() + " : " +
                    gameScore.getUserPoints());
            wins++;
        }
    }
}
