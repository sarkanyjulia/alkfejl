package hu.inf.elte.musiclibrary;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import hu.inf.elte.musiclibrary.model.User;
import lombok.AllArgsConstructor;
//import lombok.Data;
import lombok.NoArgsConstructor;

@RequestScope
@Component
//@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticatedUser {
    private User user;

    public User getUser() { return user; }
    public void setUser( User user ) { this.user = user; }
}
