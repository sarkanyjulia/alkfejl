package hu.inf.elte.musiclibrary.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.inf.elte.musiclibrary.model.User;
import hu.inf.elte.musiclibrary.repository.UserRepository;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @CrossOrigin
    @PostMapping("")
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
}
