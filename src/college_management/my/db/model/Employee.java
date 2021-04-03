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
@Table(name="employee")
public class Employee implements Serializable{ 
	@Id
	@OneToOne
	@JoinColumn(name="id", referencedColumnName="id")
	private User user; // 직원 코드
	
	@Column(name="departments")
	private String departments; // 부서
	
	@Column(name="team")
	private String team; // 팀
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getDepatemets() {
		return departments;
	}
	public void setDepatemets(String departments) {
		this.departments = departments;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	
}
