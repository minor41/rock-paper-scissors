package com.rps;

public class RpsRunner {
    public static void main(String[] args) {
        GameInfo game = new GameInfo();
        GameLogic gameLogic = new GameLogic(new GameScore());
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