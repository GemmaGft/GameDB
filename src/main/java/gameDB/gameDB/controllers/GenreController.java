package gameDB.gameDB.controllers;

import gameDB.gameDB.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class GenreController {

    @Autowired
    GenreService genreService;

    @GetMapping("/v1/genres")
    public HashMap<String, Object> getAllGenres() {
        HashMap<String, Object> config = genreService.getAllGenres();

        return config;
    }


}
