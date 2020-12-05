package college_management.my.model;

public class Lecture extends Professor {
	private String lectureCode; // 강의 코드 
	private String name; // 강의명
	private int point; // 학점 
	
	public String getLectureCode() {
		return lectureCode;
	}
	public void setLectureCode(String lectureCode) {
		this.lectureCode = lectureCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
}
