package com.rps;

public class RpsRunner {
    public static void main(String[] args) {
        GameInfo game = new GameInfo();
        GameLogic gameLogic = new GameLogic();
        game.setTheGame();
        game.keysInfo();
        gameLogic.newPlayersMove("");
        gameLogic.newComputersMove("");

    }
}