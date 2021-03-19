package college_management.my.db.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="employee")
public class Employee {
	
	@Id
	@Column(name=" employee_code")
	private String employeeCode; // 직원 코드
	
	@Column(name="departments")
	private String depatemets; // 부서
	
	@Column(name="team")
	private String team; // 팀
	
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	public String getDepatemets() {
		return depatemets;
	}
	public void setDepatemets(String depatemets) {
		this.depatemets = depatemets;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	
}
