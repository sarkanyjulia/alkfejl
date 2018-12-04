package hu.inf.elte.musiclibrary.model;

//import lombok.Data;
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

//@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "texts")

public class Text {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column
    private String lang;    

    @Column
    private String beginning;  

    @Column(name = "full_text")
    private String fullText;      

    @Column
    private String author;  
    
    @ManyToOne
    @JoinColumn
    private Translation translation;

    @ManyToMany(mappedBy = "texts")
    @JsonIgnore
    private List<Score> scores;   
    
    
    public int getId() { return id; }
    public String getLang() { return lang; }
    public String getBeginning() { return beginning; }
    public String getFullText() { return fullText; }
    public String getAuthor() { return author; }
    public Translation getTranslation() { return translation; }
    
    public void setId(int id) { this.id=id; }
    public void setLang(String lang) { this.lang=lang; }
    public void setBeginning(String beginning) { this.beginning=beginning; }
    public void setFullText(String fullText) { this.fullText=fullText; }
    public void setAuthor(String author) { this.author=author; }
    public void setTranslation(Translation translation) { this.translation=translation; }
    
}