package gameDB.gameDB.controllers;

import gameDB.gameDB.services.CreatorService;
import gameDB.gameDB.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class CreatorController {
    @Autowired
    CreatorService creatorService;

    @RequestMapping("/creators")
    Object getCreators() {
        return creatorService.getApiInstance().creatorsList(1,15);
    }
    @RequestMapping("/creators/{id}")
    Object getMovie(@PathVariable String id) {
        return creatorService.getApiInstance().creatorsRead(id);
    }
}
