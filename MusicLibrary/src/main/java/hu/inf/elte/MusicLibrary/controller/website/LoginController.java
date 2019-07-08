package hu.inf.elte.musiclibrary.controller.website;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import hu.inf.elte.musiclibrary.model.User;
import hu.inf.elte.musiclibrary.repository.UserRepository;
import hu.inf.elte.musiclibrary.service.UserService;

@Controller
public class LoginController {
	
	private static final Logger LOGGER = Logger.getLogger("LoginController");

	@Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

 
//  @RequestMapping("/login")    
    @GetMapping("/login")
    public String showLogin() {
    	LOGGER.info("showLogin() called");
    	return "login";
    }
   

}
