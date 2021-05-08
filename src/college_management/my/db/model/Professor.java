package college_management.my.db.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "professor")
public class Professor implements Serializable{
	@Id
	@OneToOne
	@JoinColumn(name="professor_id", referencedColumnName="id")
	private User user; // 교수 코드
	
	@Column(name = "faculty")
	private String faculty; // 학부
	
	@Column(name = "department")
	private String department; // 학적
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getFaculty() {
		return faculty;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String toString() {
		return "교수 코드 : " + user.getId() + ", 학부 : " + faculty + ", 학과 : " + department;
	}
}
