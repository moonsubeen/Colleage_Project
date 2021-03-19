package college_management.my.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table
public class StudentDisability{ 
	@Column(name = "disability")
	private String disability; // 장애유무
	
	@Column(name = "document")
	private String document; // 증빙서류
	
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
