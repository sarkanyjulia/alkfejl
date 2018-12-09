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

import hu.inf.elte.musiclibrary.service.TranslationService;
import hu.inf.elte.musiclibrary.model.Translation;

@RestController
@RequestMapping("/api/translation")
class TranslationController {

    @Autowired
    private TranslationService translationService;

    @CrossOrigin
    @GetMapping("/all")
    public ResponseEntity<List<Translation>> all() {
        return ResponseEntity.ok(translationService.findAll());
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<Translation> findById(@PathVariable int id) {
        Optional<Translation> optionalTranslation = translationService.findById(id);
        if (optionalTranslation.isPresent()) {
            return ResponseEntity.ok(optionalTranslation.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }       
    }

    @CrossOrigin
    @GetMapping("/beginning/{beginning}")
    public ResponseEntity<List<Translation>> findByBeginning(@PathVariable String beginning) {
        return ResponseEntity.ok(translationService.findByBeginning(beginning));
    }

    @CrossOrigin
    @Secured({ "ROLE_USER", "ROLE_ADMIN" })
    @PostMapping("")
    public ResponseEntity<Translation> save(@RequestBody Translation translation) {
        return ResponseEntity.ok(translationService.save(translation));
    }

    @CrossOrigin
    @Secured({ "ROLE_USER", "ROLE_ADMIN" })
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@RequestBody Translation translation, @PathVariable("id") int id) {
        Optional<Translation> optionalTranslation = translationService.findById(id);
        if (optionalTranslation.isPresent()) {
            translation.setId(id);
            return ResponseEntity.ok(translationService.save(translation));
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin
    @Secured({ "ROLE_USER", "ROLE_ADMIN" })
    @DeleteMapping("/{id}")
    public ResponseEntity<Translation> update(@PathVariable("id") int id) {
        Optional<Translation> optionalTranslation = translationService.findById(id);
        if (optionalTranslation.isPresent()) {
            translationService.delete(optionalTranslation.get());
            return ResponseEntity.ok().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }        
    }    

}