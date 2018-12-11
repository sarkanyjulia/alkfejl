package hu.inf.elte.musiclibrary.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.inf.elte.musiclibrary.model.User;
import hu.inf.elte.musiclibrary.repository.UserRepository;
import hu.inf.elte.musiclibrary.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @CrossOrigin
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        Optional<User> optionalUser = userRepository.findByUsername(user.getUsername());

        if (optionalUser.isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(User.Role.ROLE_GUEST);

        return ResponseEntity.ok(userRepository.save(user));
    }
    
    @CrossOrigin
    @PostMapping("/sign-in")
    public ResponseEntity<User> login(@RequestBody User user) {
        User user2 = userRepository.findByUsername(user.getUsername()).get();
        return ResponseEntity.ok(user2);
    }

    @CrossOrigin
    @Secured({ "ROLE_ADMIN" })
    @GetMapping("")
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @CrossOrigin
    @Secured({ "ROLE_ADMIN" })
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@RequestBody User user, @PathVariable("id") int id) {
        Optional<User> optionalUser = userService.findById(id);
        if (optionalUser.isPresent()) {
            user.setId(id);
            return ResponseEntity.ok(userService.save(user));
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin
    @Secured({ "ROLE_ADMIN" })
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@RequestBody User user, @PathVariable("id") int id) {
        Optional<User> optionalUser = userService.findById(id);
        if (optionalUser.isPresent()) {
            userService.delete(optionalUser.get());
            return ResponseEntity.ok().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
