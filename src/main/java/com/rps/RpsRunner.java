package com.rps;

public class RpsRunner {
    public static void main(String[] args) {
        GameScore gameScore = new GameScore();
        GameInfo gameInfo = new GameInfo(gameScore);
        GameLogic gameLogic = new GameLogic(gameScore, gameInfo);
        gameInfo.setTheGame();
        gameInfo.keysInfo();
        gameLogic.gameLogic();
        gameLogic.gameMessage();
    }
}