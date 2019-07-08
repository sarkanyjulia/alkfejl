package hu.inf.elte.musiclibrary.data;

import java.util.ArrayList;
import java.util.List;

public class ScoreFormData {	
	  
	private Integer id;	    	    
	private String firstName;    	    
	private String lastName;  	    
	private String title;      
	private String place;
	private List<TextFormData> texts = new ArrayList<>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	} 

	public List<TextFormData> getTexts() {
		return texts;
	}
	public void addText(TextFormData text) {
		texts.add(text);
	}
	
	public void removeText(int index) {
		texts.remove(index);
	}
	
}
