package hu.inf.elte.musiclibrary.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import hu.inf.elte.musiclibrary.model.Score;

@Repository
public interface ScoreRepository extends CrudRepository<Score, Integer> {

    @Override
    public List<Score> findAll();

    public List<Score> findByLastName(String lastName);

    public List<Score> findByTitle(String title);
}