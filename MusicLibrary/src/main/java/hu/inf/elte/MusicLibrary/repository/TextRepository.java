package hu.inf.elte.musiclibrary.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import hu.inf.elte.musiclibrary.model.Text;

@Repository
public interface TextRepository extends CrudRepository<Text, Integer> {

    @Override
    public List<Text> findAll();
}