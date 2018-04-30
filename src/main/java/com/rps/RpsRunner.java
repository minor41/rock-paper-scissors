package com.rps;

public class RpsRunner {
    public static void main(String[] args) {
        GameInfo gameInfo = new GameInfo();
        GameStart gameStart = new GameStart(gameInfo);
        GameLogic gameLogic = new GameLogic(gameInfo, gameStart);
        gameStart.setTheGame();
        gameStart.keysInfo();
        gameLogic.gameLogic();
        gameLogic.gameMessage();
    }
}