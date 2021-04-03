package college_management.my.db.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "lectureattendance")
public class LectureAttendance implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer no;
	
	@ManyToOne
	@JoinColumn(name="lecture_code", referencedColumnName="code", insertable = false, updatable = false)
	private Lecture lecture; // 강의 코드 
	
	@ManyToOne
	@JoinColumn(name = "student_id", referencedColumnName="student_id")
	private Student student; // 학생 번호
	
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

	public String getAttendance() {
		return attendance;
	}

	public void setAttendance(String attendance) {
		this.attendance = attendance;
	}
	
}
