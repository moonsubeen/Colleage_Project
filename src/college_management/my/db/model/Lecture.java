package college_management.my.db.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	@Column(name="code")
	private String code; // 강의 코드 
	
	@ManyToOne
	@JoinColumn(name = "professor_id", referencedColumnName="professor_id", insertable = false, updatable = false)
	private Professor professor; // 교수 번호
	
	@Column(name = "lecure_name")
	private String name; // 강의명
	
	@Column(name = "point")
	private int point; // 학점 
	
	@Column(name = "year")
	private int year; // 년도
	
	@Column(name = "semester")
	private int semester; // 학기
	
	@Column(name = "day")
	private String day; // 요일
	
	@Column(name = "time")
	private String time;
//	private HashMap<String, List<Integer>> time = new HashMap<String, List<Integer>>(); // 시간
//	private HashMap<String, Integer> time = new HashMap<String, Integer>(); // 시간
	
	@Column(name = "count")
	private int count; // 인원 수
	
	@Column(name = "lecture_plan")
	private String lecturePlan; // 강의 계획서
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	
//	public HashMap<String, Integer> getTime() {
//		return time;
//	}
//	public void setTime(HashMap<String, Integer> time) {
//		this.time = time;
//	}
	//	public HashMap<String, List<Integer>> getTime() {
//		return time;
//	}
//	public void setTime(HashMap<String, List<Integer>> time) {
//		this.time = time;
//	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String lectureCode) {
		this.code = lectureCode;
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
	public String toString() {
		return "강의 코드 : " + code + ", 담당 교수 : " + professor.getUser().getName() + ", 교수코드 : " + professor.getUser().getId() 
				+ ", 강의명 : " + name + ", 년도 : " + year + "년도, 학기 : " + semester 
				+ ", 요일 : " + day + ", 시간 : " + time + ", 인원 수  : " + count + "명";
	}
}
