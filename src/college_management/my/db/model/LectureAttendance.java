package college_management.my.db.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class LectureAttendance {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer no;
	
	@ManyToOne
	@JoinColumn(name="lecture_code", referencedColumnName="code")
	private Lecture lecture; // 강의 코드 
	
	@ManyToOne
	@JoinColumn(name = "student_id", referencedColumnName="id")
	private Student student; // 학생 번호
	
	@Column(name = "year")
	private int year; // 년도
	
	@Column(name = "semester")
	private int semester; // 학기
	
	@Column(name = "day")
	private int day; // 요일
	
	@Column(name = "attendance")
	private String attendance; // 출석

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public Lecture getLecture() {
		return lecture;
	}

	public void setLecture(Lecture lecture) {
		this.lecture = lecture;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

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

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getAttendance() {
		return attendance;
	}

	public void setAttendance(String attendance) {
		this.attendance = attendance;
	}
	
}
