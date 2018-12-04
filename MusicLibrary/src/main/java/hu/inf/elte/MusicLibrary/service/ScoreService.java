package hu.inf.elte.musiclibrary.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import hu.inf.elte.musiclibrary.repository.ScoreRepository;
import hu.inf.elte.musiclibrary.model.Score;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> findAll() {
        return scoreRepository.findAllByOrderByLastNameAscFirstNameAscTitleAsc();
    }

    public Optional<Score> findById(int id) {
        return scoreRepository.findById(id);
    }

    public List<Score> findByName(String name) {
        return scoreRepository.findByLastNameContainingIgnoreCaseOrderByFirstNameAscTitleAsc(name);
    }

    public List<Score> findByTitle(String title) {
        return scoreRepository.findByTitleContainingIgnoreCaseOrderByTitleAscLastNameAscFirstNameAsc(title);
    }

    public Score save(Score score) {
        return scoreRepository.save(score);
    }

	public void delete(Score score) {
        scoreRepository.delete(score);
	}
}