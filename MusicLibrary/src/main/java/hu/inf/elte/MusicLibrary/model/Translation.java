package hu.inf.elte.musiclibrary.model;

//import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Table;


import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.List;

import javax.persistence.Column;

//@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "translations")

public class Translation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column
    private String beginning;  

    @Column(name = "full_text")
    private String fullText;      

    @OneToMany(mappedBy = "translation")
    private List<Text> texts;

    
    public int getId() { return id; }
    public String getBeginning() { return beginning; }
    public String getFullText() { return fullText; }

    public void setId(int id) { this.id=id; }
    public void setBeginning(String beginning) { this.beginning=beginning; }
    public void setFullText(String fullText) { this.fullText=fullText; }
    

}