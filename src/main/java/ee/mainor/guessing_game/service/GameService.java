package ee.mainor.guessing_game.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class GameService {

    private final Map<Long, Integer> gameNumbers = new HashMap<>();
    private final Map<Long, Integer> gameAttempts = new HashMap<>();
    private long nextGameId = 1;

    public Long createGame() {
        long gameId = nextGameId++;
        int randomNumber = new Random().nextInt(100) + 1;

        gameNumbers.put(gameId, randomNumber);
        gameAttempts.put(gameId, 0);

        return gameId;
    }

    public String guessNumber(Long gameId, Integer number) {
        if (!gameNumbers.containsKey(gameId)) {
            return "Game not found";
        }

        int secretNumber = gameNumbers.get(gameId);
        int attempts = gameAttempts.get(gameId) + 1;
        gameAttempts.put(gameId, attempts);

        if (secretNumber < number) {
            return "Nr is smaller";
        } else if (secretNumber > number) {
            return "Nr is bigger";
        } else {
            return "Correct, it took you " + attempts + " times";
        }
    }
}