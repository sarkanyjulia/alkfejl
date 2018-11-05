package hu.inf.elte.musiclibrary.controller;

import java.util.List;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import hu.inf.elte.musiclibrary.service.TranslationService;
import hu.inf.elte.musiclibrary.model.Translation;

@RestController
@RequestMapping("/api/translation")
class TranslationController {

    @Autowired
    private TranslationService translationService;

    @GetMapping("/all")
    public List<Translation> all() {
        return translationService.findAll();
    }

    @GetMapping("/{id}")
    public Translation findById(@PathVariable int id) {
        return translationService.findById(id);
    }

    @GetMapping("/beginning/{beginning}")
    public List<Translation> findByBeginning(@PathVariable String beginning) {
        return translationService.findByBeginning(beginning);
    }
}