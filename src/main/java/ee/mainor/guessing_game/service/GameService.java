package ee.mainor.guessing_game.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

@Service
public class GameService {

    private final Map<String, Integer> games = new HashMap<>();
    private final Map<String, Integer> attempts = new HashMap<>();
    private final Random random = new Random();

    public String startGame() {
        String gameId = UUID.randomUUID().toString();
        int secretNumber = random.nextInt(100) + 1;

        games.put(gameId, secretNumber);
        attempts.put(gameId, 0);

        return gameId;
    }

    public String guessNumber(String gameId, int number) {
        if (!games.containsKey(gameId)) {
            return "Game not found";
        }

        int secretNumber = games.get(gameId);
        int currentAttempts = attempts.get(gameId) + 1;
        attempts.put(gameId, currentAttempts);

        if (secretNumber < number) {
            return "Nr is smaller";
        }

        if (secretNumber > number) {
            return "Nr is bigger";
        }

        return "Correct, it took you " + currentAttempts + " times";
    }

    public static class NameRequest {

        private String firstName;
        private String lastName;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }
}