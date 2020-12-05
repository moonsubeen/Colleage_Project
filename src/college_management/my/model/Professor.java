package college_management.my.model;

public class Professor extends User{
	private String professorCode;; // 교수 코드
	private String undergraduate; // 학부
	private String major; // 학적
	private String lecturePlan; // 강의 계획서
	
	public String getProfessorCode() {
		return professorCode;
	}
	public void setProfessorCode(String professorCode) {
		this.professorCode = professorCode;
	}
	public String getUndergraduate() {
		return undergraduate;
	}
	public void setUndergraduate(String undergraduate) {
		this.undergraduate = undergraduate;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getLecturePlan() {
		return lecturePlan;
	}
	public void setLecturePlan(String lecturePlan) {
		this.lecturePlan = lecturePlan;
	}
	
}
