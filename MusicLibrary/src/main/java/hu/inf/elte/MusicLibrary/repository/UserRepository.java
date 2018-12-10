package hu.inf.elte.musiclibrary.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hu.inf.elte.musiclibrary.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    public List<User> findAll(); 
    public Optional<User> findByUsername(String username);
}