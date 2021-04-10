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
@Table(name = "lecturehistory")
public class LectureHistory implements Serializable{
	@EmbeddedId
	private LectureHistoryID id;
	
//	@ManyToOne
//	@JoinColumn(name="lecture_code", referencedColumnName="code", insertable = false, updatable = false)
//	private Lecture lecture; // 강의 코드 
//	
//	@ManyToOne
//	@JoinColumn(name = "student_id", referencedColumnName="id", insertable = false, updatable = false)
//	private Student student; // 학생 번호
	
	@Column(name = "grade")
	private int grade; // 성적
	
	@Column(name = "rank")
	private String rank; // 등급
	
	@Column(name = "problem")
	private String problem; // 이의 제기
	
	@Column(name = "evaluation")
	private String evaluation; // 강의 평가
	
	@Column(name = "count")
	private int count; // 신청자 수
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

//	public Integer getNo() {
//		return no;
//	}
//
//	public void setNo(Integer no) {
//		this.no = no;
//	}

//	public Lecture getLecture() {
//		return lecture;
//	}
//
//	public void setLecture(Lecture lecture) {
//		this.lecture = lecture;
//	}
//
//	public Student getStudent() {
//		return student;
//	}
//
//	public void setStudent(Student student) {
//		this.student = student;
//	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}
	public String toString() {
		return "강의 : " + /*lecture.getName()*/  ", 학생 이름 : " + /*student.getUser().getName() + */ ", 성적 : " + grade
				+ ", 등급 : " + rank + ", 평가 : " + evaluation + ", 이의 제기 : " + problem + "강의 인원 수 : " + count; 
	}
	
}
