package hu.inf.elte.musiclibrary.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
//import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false)
    private String username;
    
    @Column(nullable = false, name="pwd")
    private String password;

    @Column(nullable = false, name="user_role")
    @Enumerated(EnumType.STRING)
    private Role role;
    
    public enum Role {
        ROLE_GUEST, ROLE_USER, ROLE_ADMIN
    }

    public int getId() { return id; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public Role getRole() { return role; }

    public void setId(int id) { this.id = id; }
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
    public void setRole(Role role) { this.role = role; }
    
}