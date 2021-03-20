package college_management.my.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name="disability")
public class StudentDisability{ 
	@Column(name="state")
	private boolean state; // 장애 유무
	
	@Column(name = "disability")
	private String disability; // 병명
	
	@Column(name = "document")
	private String document; // 증빙서류
	
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public String getDisability() {
		return disability;
	}
	public void setDisability(String disability) {
		this.disability = disability;
	}
	public String getDocument() {
		return document;
	}
	public void setDocument(String document) {
		this.document = document;
	}
	
}
