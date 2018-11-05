package hu.inf.elte.musiclibrary.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import hu.inf.elte.musiclibrary.service.ScoreService;
import hu.inf.elte.musiclibrary.model.Score;

@RestController
@RequestMapping("/api/score")
class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @GetMapping("/all")
    public List<Score> all() {
        return scoreService.findAll();
    }

    @GetMapping("/byLastName/{lastName}")
    public List<Score> findByLastName(@PathVariable String lastName) {
        return scoreService.findByLastName(lastName);
    }  
    
    @GetMapping("/byTitle/{title}")
    public List<Score> findByTitle(@PathVariable String title) {
        return scoreService.findByTitle(title);
    }      
}