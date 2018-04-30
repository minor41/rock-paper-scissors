package com.rps;

public class GameInfo {
    private String user;
    private int roundsCount;
    private int userPoints;
    private int computerPoints;
    private Move playerMove = new Move();
    private Move computerMove = new Move();

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getRoundsCount() {
        return roundsCount;
    }

    public void setRoundsCount(int roundsCount) {
        this.roundsCount = roundsCount;
    }

    public int getUserPoints() {
        return userPoints;
    }

    public void setUserPoints(int userPoints) {
        this.userPoints = userPoints;
    }

    public int getComputerPoints() {
        return computerPoints;
    }

    public void setComputerPoints(int computerPoints) {
        this.computerPoints = computerPoints;
    }

    public Move getPlayerMove() {
        return playerMove;
    }

    public void setPlayerMove(Move playerMove) {
        this.playerMove = playerMove;
    }

    public Move getComputerMove() {
        return computerMove;
    }

    public void setComputerMove(Move computerMove) {
        this.computerMove = computerMove;
    }

    @Override
    public String toString() {
        return "GameInfo: \n" +
                "user: " + user + "\n" +
                user +" have points: " + userPoints + "\n"+
                "computer has points: " + computerPoints + "\n"+
                user +" chose: " + playerMove + "\n"+
                "computer chose: " + computerMove + "\n";
    }
}
