package com.example.game;

public class GameResponse {
    private String result;
    private int attempt;
    private int score;
    private boolean gameOver;

    public GameResponse(String result, int attempt, int score, boolean gameOver) {
        this.result = result;
        this.attempt = attempt;
        this.score = score;
        this.gameOver = gameOver;
    }

    public String getResult() { return result; }
    public int getAttempt() { return attempt; }
    public int getScore() { return score; }
    public boolean isGameOver() { return gameOver; }
}
