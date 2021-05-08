package college_management.my.db.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "lectureattendance")
public class LectureAttendance implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer no;
	
	@ManyToOne
	@JoinColumn(name="lecture_code", referencedColumnName="code")
	private Lecture lecture; // 강의 코드 
	
	@ManyToOne
	@JoinColumn(name = "student_id", referencedColumnName="student_id")
	private Student student; // 학생 번호
	
	@Column(name = "month")
	private int month; // 월
	
	@Column(name = "day")
	private String day; //일
	
	@Column(name = "attendance")
	private String attendance; // 출석

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

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getAttendance() {
		return attendance;
	}

	public void setAttendance(String attendance) {
		this.attendance = attendance;
	}
	
	public String toString() {
		return "강의코드 : " + lecture.getCode() + ", 제목 : " + lecture.getName() 
		+ ", " + month + "월, " + day + "일, 이름 : " + student.getUser().getName() + ", 출석 : " + attendance;
	}
	
}
