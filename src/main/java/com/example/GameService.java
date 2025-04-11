package com.example.game;

import org.springframework.stereotype.Service;

@Service
public class GameService {
    private int randomNumber;
    private int attempts;
    private boolean gameOver;
    private int maxAttempts = 10;

    public GameService() {
        startNewGame();
    }

    public void startNewGame() {
        this.randomNumber = (int) (Math.random() * 100);
        this.attempts = 0;
        this.gameOver = false;
    }

    public GameResponse checkGuess(int guess) {
        if (gameOver) {
            return new GameResponse("Game is over! Please restart.", attempts, 0, true);
        }

        attempts++;
        if (guess == randomNumber) {
            gameOver = true;
            int score = (maxAttempts - attempts + 1) * 10;
            return new GameResponse("🎉 Correct! You scored " + score + " points.", attempts, score, true);
        }

        if (attempts >= maxAttempts) {
            gameOver = true;
            return new GameResponse("❌ Out of attempts! The number was " + randomNumber, attempts, 0, true);
        }

        String msg = guess < randomNumber ? "Too low!" : "Too high!";
        return new GameResponse(msg, attempts, 0, false);
    }
}
