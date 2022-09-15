package gameDB.gameDB.controllers;

import gameDB.gameDB.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class GameController {

    @Autowired
    GameService gameService;

    @GetMapping("/v1/games")
    public HashMap<String, Object> getAllGenres() {
        HashMap<String, Object> games = gameService.getAllGames();

        return games;
    }

    @GetMapping("/v1/games/{game_pk}/additions")
    public HashMap<String,Object> getListOfDlcForGame(@PathVariable int game_pk){
        HashMap<String, Object> dlcs = gameService.getListOfDlcForGame(game_pk);

        return dlcs;
    }
}
