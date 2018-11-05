package hu.inf.elte.musiclibrary.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.List;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "texts")

public class Text {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    
    @Column
    private String lang;    

    @Column
    private String beginning;  

    @Column
    private String full_text;      

    @Column
    private String author;  
    
    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Translation translation;

    @ManyToMany(mappedBy = "texts")
    //@JsonIgnore
    private List<Score> scores;    

}