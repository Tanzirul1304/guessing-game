package ee.mainor.guessing_game.controller;

import ee.mainor.guessing_game.service.GameService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class NameController {

    @PostMapping("/name")
    public Map<String, String> getFullName(@RequestBody GameService.NameRequest request) {
        String fullName = request.getFirstName() + " " + request.getLastName();
        return Map.of("fullName", fullName);
    }
}