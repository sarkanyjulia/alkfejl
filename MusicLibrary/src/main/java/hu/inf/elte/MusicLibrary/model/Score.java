package hu.inf.elte.musiclibrary.model;

//import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

import java.util.List;

//@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "scores")

public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "composer_fname")
    private String firstName;    

    @Column(name = "composer_lname")
    private String lastName;  

    @Column
    private String title;      

    @Column
    private String place; 
    
    @ManyToMany
    @JoinTable
    private List<Text> texts;    

    public int getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getTitle() { return title; }
    public String getPlace() { return place; }

    public void setId(int id) { this.id = id; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setTitle(String title) { this.title = title; }
    public void setPlace(String place) { this.place = place; }




}