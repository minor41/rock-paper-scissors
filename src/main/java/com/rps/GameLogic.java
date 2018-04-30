package com.rps;

import java.util.Random;
import java.util.Scanner;

public class GameLogic {
    private Scanner sc = new Scanner(System.in);
    private GameInfo gameInfo;
    private GameStart gameStart;
    private int wins = 0;
    private int loses = 0;

    public GameLogic(GameInfo gameInfo, GameStart gameStart) {
        this.gameStart = gameStart;
        this.gameInfo = gameInfo;
    }

    private GameInfo getGameInfo() {
        return gameInfo;
    }

    private String newMove() {
        System.out.println("Your Move: ");
        return sc.nextLine();
    }

    private void newPlayersMove(String playerMove) throws InvalidMoveException {
        if (playerMove.equals("1") || playerMove.equals("2") || playerMove.equals("3")) {
            if (playerMove.equals("1")) gameInfo.setPlayerMove(new Rock());
            if (playerMove.equals("2")) gameInfo.setPlayerMove(new Paper());
            if (playerMove.equals("3")) gameInfo.setPlayerMove(new Scissors());
        } else {
            throw new InvalidMoveException();
        }
    }

    private void newComputerMove() {
        Random random = new Random();
        int r = random.nextInt(3) + 1;
        if (r == 1) gameInfo.setComputerMove(new Rock());
        if (r == 2) gameInfo.setComputerMove(new Paper());
        if (r == 3) gameInfo.setComputerMove(new Scissors());
        System.out.println("Computer chose " + r);
    }

    private void results(Move playerMove, Move computerMove) {
        if (playerMove.equals(computerMove)) {
            System.out.println("Draw! Next Round \n");
        }
        if (playerMove.equals(new Rock())) {
            if (computerMove.equals(new Scissors())) {
                gameInfo.setUserPoints(gameInfo.getUserPoints() + 1);
                System.out.println("Rock beats Scissors: " + gameInfo.getUser() + " wins this round \n");
            }
            if (computerMove.equals(new Paper())) {
                gameInfo.setComputerPoints(gameInfo.getComputerPoints() + 1);
                System.out.println("Paper beats Rock: computer wins this round \n");
            }
        }
        if (playerMove.equals(new Paper())) {
            if (computerMove.equals(new Rock())) {
                gameInfo.setUserPoints(gameInfo.getUserPoints() + 1);
                System.out.println("Paper beats Rock: " + gameInfo.getUser() + " win this round \n");
            }
            if (computerMove.equals(new Scissors())) {
                gameInfo.setComputerPoints(gameInfo.getComputerPoints() + 1);
                System.out.println("Scissors beat Paper: computer wins this round \n");
            }
        }
        if (playerMove.equals(new Scissors())) {
            if (computerMove.equals(new Paper())) {
                gameInfo.setUserPoints(gameInfo.getUserPoints() + 1);
                System.out.println("Scissors beat Paper: " + gameInfo.getUser() + " wins this round \n");
            }
            if (computerMove.equals(new Rock())) {
                gameInfo.setComputerPoints(gameInfo.getComputerPoints() + 1);
                System.out.println("Rock beats Scissors: computer wins this round \n");
            }
        }
    }

    public void gameLogic() {
        gameLogic(gameInfo.getRoundsCount());
    }

    public void gameLogic(int roundsCount) {
        boolean endGame = false;
        while (!endGame) {
            if (gameInfo.getComputerPoints() == roundsCount || gameInfo.getUserPoints() == roundsCount) {
                return;
            }
            System.out.println(gameInfo);
            String move = newMove();
            while (move.equals("n")) {
                System.out.println(gameInfo.getUser() + " are you sure you want to start new game? (y/n)");
                String options = sc.nextLine();
                if (options.equals("y")) {
                    gameStart.setTheGame();
                } else {
                    move = newMove();
                }
            }
            while (move.equals("x")) {
                System.out.println(gameInfo.getUser() + " are you sure you want to quit? (y/n)");
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
            results(getGameInfo().getPlayerMove(), getGameInfo().getComputerMove());
        }
    }

    public void gameMessage() {
        if (gameInfo.getComputerPoints() > gameInfo.getUserPoints()) {
            System.out.println(gameInfo);
            System.out.println("Computer won the this game \n" + gameInfo.getComputerPoints() + " : " +
                    gameInfo.getUserPoints());
            //loses++;
        } else if (gameInfo.getUserPoints() > gameInfo.getComputerPoints()) {
            System.out.println(gameInfo);
            System.out.println(gameInfo.getUser() + " won the this game \n" + gameInfo.getComputerPoints() + " : " +
                    gameInfo.getUserPoints());
            //wins++;
        }
    }
}
