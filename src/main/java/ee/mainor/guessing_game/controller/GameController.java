package ee.mainor.guessing_game.controller;

import ee.mainor.guessing_game.service.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/game")
    public String startGame() {
        return gameService.startGame();
    }

    @GetMapping("/game/{gameId}/guess/{number}")
    public String guessNumber(@PathVariable String gameId, @PathVariable int number) {
        return gameService.guessNumber(gameId, number);
    }
}