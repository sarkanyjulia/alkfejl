package hu.inf.elte.musiclibrary.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.List;

import javax.persistence.Column;

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
	@JsonIgnore
	private List<Text> texts;

	public Translation() {
		super();
	}

	public Translation(int id, String beginning, String fullText, List<Text> texts) {
		super();
		this.id = id;
		this.beginning = beginning;
		this.fullText = fullText;
		this.texts = texts;
	}

	public int getId() {
		return id;
	}

	public String getBeginning() {
		return beginning;
	}

	public String getFullText() {
		return fullText;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setBeginning(String beginning) {
		this.beginning = beginning;
	}

	public void setFullText(String fullText) {
		this.fullText = fullText;
	}

	public List<Text> getTexts() {
		return texts;
	}

	public void setTexts(List<Text> texts) {
		this.texts = texts;
	}

}