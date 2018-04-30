package com.rps;

public class RpsRunner {
    public static void main(String[] args) {
        GameInfo game = new GameInfo();
        GameScore gameScore = new GameScore();
        GameLogic gameLogic = new GameLogic(gameScore);
        game.setTheGame();
        game.keysInfo();
        try {
            gameLogic.newPlayersMove("");
        } catch (InvalidMoveException e) {
        }
        gameLogic.newComputerMove();
        gameLogic.results(new Move(), new Move());

    }
}