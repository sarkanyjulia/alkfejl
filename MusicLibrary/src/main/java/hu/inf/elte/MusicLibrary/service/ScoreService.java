package hu.inf.elte.musiclibrary.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import hu.inf.elte.musiclibrary.repository.ScoreRepository;
import hu.inf.elte.musiclibrary.model.Score;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> findAll() {
        return scoreRepository.findAll();
    }

    public List<Score> findByLastName(String lastName) {
        return scoreRepository.findByLastName(lastName);
    }

    public List<Score> findByTitle(String title) {
        return scoreRepository.findByTitle(title);
    }
}