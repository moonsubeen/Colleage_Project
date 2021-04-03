package college_management.my.db.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="disability")
public class UserDisability implements Serializable{
	@Id
	@OneToOne
	@JoinColumn(name="id", referencedColumnName="id")
	private User user; // 아이디
	
	@Column(name="state")
	private boolean state; // 장애 유무
	
	@Column(name = "disability")
	private String disability; // 병명
	
	@Column(name = "document")
	private String document; // 증빙서류
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
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
	public String toString() {
		return "유무 : " + state + ", 장애 : " + disability + ", 증빙서류 : " + document;
	}
	
}
