package hu.inf.elte.musiclibrary.data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import hu.inf.elte.musiclibrary.model.Translation;

public class TextFormData {
  
    private Integer id;    
    private String lang;    
    private String beginning;  
    private String fullText;      
    private String author;     
    private Integer translationId;   
    private String translationBeginning;    
    private String translationFullText;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public String getBeginning() {
		return beginning;
	}
	public void setBeginning(String beginning) {
		this.beginning = beginning;
	}
	public String getFullText() {
		return fullText;
	}
	public void setFullText(String fullText) {
		this.fullText = fullText;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getTranslationId() {
		return translationId;
	}
	public void setTranslationId(Integer translationId) {
		this.translationId = translationId;
	}
	public String getTranslationBeginning() {
		return translationBeginning;
	}
	public void setTranslationBeginning(String translationBeginning) {
		this.translationBeginning = translationBeginning;
	}
	public String getTranslationFullText() {
		return translationFullText;
	}
	public void setTranslationFullText(String translationText) {
		this.translationFullText = translationText;
	}
    
    
	
}
