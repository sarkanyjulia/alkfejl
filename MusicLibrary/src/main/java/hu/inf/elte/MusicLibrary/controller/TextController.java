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
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;

import hu.inf.elte.musiclibrary.service.TextService;
import hu.inf.elte.musiclibrary.model.Text;

@RestController
@RequestMapping("/api/text")
class TextController {

    @Autowired
    private TextService textService;

    @CrossOrigin
    @GetMapping("")
    public ResponseEntity<List<Text>> all() {
        return ResponseEntity.ok(textService.findAll());
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<Text> findById(@PathVariable("id") int id) {
        Optional<Text> optionalText = textService.findById(id);
        if (optionalText.isPresent()) {
            return ResponseEntity.ok(optionalText.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin
    @GetMapping("/beginning/{beginning}")
    public ResponseEntity<List<Text>> findByBeginning(@PathVariable("beginning") String beginning) {
        return ResponseEntity.ok(textService.findByBeginning(beginning));
    }

    @CrossOrigin
    @GetMapping("/lang/{lang}")
    public ResponseEntity<List<Text>> findByLang(@PathVariable("lang") String lang) {
        return ResponseEntity.ok(textService.findByLang(lang));
    }

    @CrossOrigin
    @Secured({ "ROLE_USER", "ROLE_ADMIN" })
    @PostMapping("")
    public ResponseEntity<Text> save(@RequestBody Text text) {
        return ResponseEntity.ok(textService.save(text));
    }

    @CrossOrigin
    @Secured({ "ROLE_USER", "ROLE_ADMIN" })
    @PutMapping("/{id}")
    public ResponseEntity<Text> update(@RequestBody Text text, @PathVariable("id") int id) {
        Optional<Text> optionalText = textService.findById(id);
        if (optionalText.isPresent()) {
            text.setId(id);
            return ResponseEntity.ok(textService.save(text));
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin
    @Secured({ "ROLE_USER", "ROLE_ADMIN" })
    @DeleteMapping("/{id}")
    public ResponseEntity<Text> update(@PathVariable("id") int id) {
        Optional<Text> optionalText = textService.findById(id);
        if (optionalText.isPresent()) {
            textService.delete(optionalText.get());
            return ResponseEntity.ok().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }        
    }    
}