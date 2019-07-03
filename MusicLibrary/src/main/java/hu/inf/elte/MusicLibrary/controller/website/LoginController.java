package hu.inf.elte.musiclibrary.controller.website;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import hu.inf.elte.musiclibrary.repository.UserRepository;
import hu.inf.elte.musiclibrary.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    
}
