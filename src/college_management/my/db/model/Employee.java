package college_management.my.db.model;

public class Employee {
	private String employeeCode; // 직원 코드
	private String depatemets; // 부서
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
