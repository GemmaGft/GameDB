package gameDB.gameDB.controllers;

import gameDB.gameDB.services.CreatorService;
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

    @GetMapping("/creators")
    public HashMap<String, Object> getCreators() {
        return creatorService.getCreators();
    }
    @GetMapping("/creators/{id}")
    public HashMap<String, Object> getCreatorById(@PathVariable int id) {
        return creatorService.getCreatorById(id);
    }

}
