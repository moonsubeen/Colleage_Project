package college_management.my.db.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "student")
public class Student implements Serializable{
	@Id
	@OneToOne
	@JoinColumn(name="student_id", referencedColumnName="id")
	private User user; // 학번
	
	@OneToMany(mappedBy = "student")
	private Set<LectureHistory> history = new HashSet<LectureHistory>();
	
	@Column(name = "major")
	private String major; // 학과
	
	@Column(name = "campus")
	private String campus; // 캠퍼스
	
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
