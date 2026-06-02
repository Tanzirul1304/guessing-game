Guessing Game API

This is a simple Spring Boot REST API for a number guessing game.

Endpoints
Create Game

GET /game

Returns a game ID.

Guess Number

GET /game/{gameId}/guess/{number}

Responses:

"Nr is bigger"
"Nr is smaller"
"Correct, it took you X times"
Tech Stack
Java
Spring Boot
Gradle
Author

Tanzirul Islam
