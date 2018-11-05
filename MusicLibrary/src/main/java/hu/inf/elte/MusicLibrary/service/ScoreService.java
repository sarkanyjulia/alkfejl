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

    public Score findById(int id) {
        return scoreRepository.findById(id);
    }

    public List<Score> findByName(String name) {
        return scoreRepository.findByLastNameContainingIgnoreCaseOrderByTitleAsc(name);
    }

    public List<Score> findByTitle(String title) {
        return scoreRepository.findByTitleContainingIgnoreCaseOrderByTitleAsc(title);
    }
}