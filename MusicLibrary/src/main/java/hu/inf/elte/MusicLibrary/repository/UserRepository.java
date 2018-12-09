package hu.inf.elte.musiclibrary.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import hu.inf.elte.musiclibrary.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}