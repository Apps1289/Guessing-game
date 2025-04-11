package com.example.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GameController {
    @Autowired
    private GameService gameService;

    @GetMapping("/start")
    public String startGame() {
        gameService.startNewGame();
        return "Game started. Guess a number between 0 and 99.";
    }

    @PostMapping("/guess")
public GameResponse guessNumber(@RequestBody GuessRequest request) {
    return gameService.checkGuess(request.getGuess());
}

}

class GuessRequest {
    private int guess;
    public int getGuess() { return guess; }
    public void setGuess(int guess) { this.guess = guess; }
}
