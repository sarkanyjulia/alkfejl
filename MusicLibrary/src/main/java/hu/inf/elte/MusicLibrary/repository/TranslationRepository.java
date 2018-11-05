package hu.inf.elte.musiclibrary.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import hu.inf.elte.musiclibrary.model.Translation;

@Repository
public interface TranslationRepository extends CrudRepository<Translation, Integer> {

    @Override
    public List<Translation> findAll();
}