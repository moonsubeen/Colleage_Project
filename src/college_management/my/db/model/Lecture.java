package college_management.my.db.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "lecture")
public class Lecture implements Serializable{
	@Id
	@Column(name="lecture_code")
	private String lectureCode; // 강의 코드 
	
	@ManyToOne
	@JoinColumn(name = "professor_id", insertable = false, updatable = false)
	private Professor professor; // 교수 번호
	
	@Column(name = "lecure_name")
	private String name; // 강의명
	
	@Column(name = "point")
	private int point; // 학점 
	
	@Column(name = "lecture_plan")
	private String lecturePlan; // 강의 계획서
	
	public String getLectureCode() {
		return lectureCode;
	}
	public void setLectureCode(String lectureCode) {
		this.lectureCode = lectureCode;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
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
	public String getLecturePlan() {
		return lecturePlan;
	}
	public void setLecturePlan(String lecturePlan) {
		this.lecturePlan = lecturePlan;
	}
}
