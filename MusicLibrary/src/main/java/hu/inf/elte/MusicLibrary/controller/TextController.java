package hu.inf.elte.musiclibrary.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import hu.inf.elte.musiclibrary.service.TextService;
import hu.inf.elte.musiclibrary.model.Text;

@RestController
@RequestMapping("/api/text")
class TextController {

    @Autowired
    private TextService textService;

    @GetMapping("/all")
    public List<Text> all() {
        return textService.findAll();
    }
}