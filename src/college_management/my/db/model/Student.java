package college_management.my.db.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "student")
public class Student implements Serializable{
	@Id
	@OneToOne
	@JoinColumn(name="id", referencedColumnName="id")
	private User user;; // 학번
	
//	@ManyToOne
//	@JoinColumn(name="id", referencedColumnName="id")
//	private User user;
	
	@Column
	private String major; // 학적
	
	@Column
	private String campus; // 캠퍼스
	
//	public String getStudentCode() {
//		return studentCode;
//	}
//	public void setStudentCode(String studentCode) {
//		this.studentCode = studentCode;
//	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getCampus() {
		return campus;
	}
	public void setCampus(String campus) {
		this.campus = campus;
	}
	public String toString() {
		return "StudentCode : " + user.getId() + ", Major : " + major + ", Campus : " + campus;
	}
	
}
