package hu.inf.elte.musiclibrary.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import hu.inf.elte.musiclibrary.repository.TextRepository;
import hu.inf.elte.musiclibrary.model.Text;

@Service
public class TextService {

    @Autowired
    private TextRepository textRepository;

    public List<Text> findAll() {
        return textRepository.findAll();
    }
}