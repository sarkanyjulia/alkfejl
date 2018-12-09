package hu.inf.elte.musiclibrary.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import hu.inf.elte.musiclibrary.AuthenticatedUser;
import hu.inf.elte.musiclibrary.service.ScoreService;
import hu.inf.elte.musiclibrary.model.Score;

@RestController
@RequestMapping("/api/score")
class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @Autowired 
    private AuthenticatedUser authenticatedUser;

    @CrossOrigin
    @GetMapping("")
    public ResponseEntity<List<Score>> findAll() {
        return ResponseEntity.ok(scoreService.findAll());
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<Score> findById(@PathVariable("id") int id) {
        Optional<Score> optionalScore = scoreService.findById(id);
        if (optionalScore.isPresent()) {
            return ResponseEntity.ok(optionalScore.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }    

    @CrossOrigin
    @GetMapping("/name/{name}")
    public ResponseEntity<List<Score>> findByName(@PathVariable("name") String name) {
        return ResponseEntity.ok(scoreService.findByName(name));
              
    }  
    
    @CrossOrigin
    @GetMapping("/title/{title}")
    public ResponseEntity<List<Score>> findByTitle(@PathVariable("title") String title) {
        return ResponseEntity.ok(scoreService.findByTitle(title));            
    }  
    
    @CrossOrigin
    @Secured({ "ROLE_USER", "ROLE_ADMIN" })
    @PostMapping("")
    public ResponseEntity<Score> save(@RequestBody Score score) {
        return ResponseEntity.ok(scoreService.save(score));
    }

    @CrossOrigin
    @Secured({ "ROLE_USER", "ROLE_ADMIN" })
    @PutMapping("/{id}")
    public ResponseEntity<Score> update(@RequestBody Score score, @PathVariable("id") int id) {
        Optional<Score> optionalScore = scoreService.findById(id);
        if (optionalScore.isPresent()) {
            score.setId(id);
            return ResponseEntity.ok(scoreService.save(score));
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin
    @Secured({ "ROLE_USER", "ROLE_ADMIN" })
    @DeleteMapping("/{id}")
    public ResponseEntity<Score> update(@PathVariable("id") int id) {
        Optional<Score> optionalScore = scoreService.findById(id);
        if (optionalScore.isPresent()) {
            scoreService.delete(optionalScore.get());
            return ResponseEntity.ok().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }        
    }
}