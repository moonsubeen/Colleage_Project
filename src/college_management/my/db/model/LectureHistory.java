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
@Table(name = "lectureHistory")
public class LectureHistory implements Serializable{
	@EmbeddedId
	private LectureHistoryID id = new LectureHistoryID(); 

//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private Integer no;
	
	@ManyToOne
	@MapsId("lecture")
	@JoinColumn(name = "lecture_code", referencedColumnName = "code" /*, insertable = false, updatable = false */)
	private Lecture lecture; // 강의 코드

	@ManyToOne
	@MapsId("student")
	@JoinColumn(name = "student_id", referencedColumnName = "student_id" /*, insertable = false, updatable = false */)
	private Student student; // 학생 번호
	
	@Column(name = "grade")
	private int grades; // 성적
	
	@Column(name = "ranks")
	private String ranks; // 등급
	
	@Column(name = "problem")
	private String problems; // 이의 제기
	
	@Column(name = "evaluation")
	private String evaluations; // 강의 평가
	
	@Column(name = "count")
	private int counts; // 신청자 수
	
	public LectureHistoryID getId() {
		return id;
	}

	public void setId(LectureHistoryID id) {
		this.id = id;
	}

	public int getCount() {
		return counts;
	}

	public void setCount(int counts) {
		this.counts = counts;
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

	public int getGrade() {
		return grades;
	}

	public void setGrade(int grades) {
		this.grades = grades;
	}

	public String getRank() {
		return ranks;
	}

	public void setRank(String ranks) {
		this.ranks = ranks;
	}

	public String getProblem() {
		return problems;
	}

	public void setProblem(String problems) {
		this.problems = problems;
	}

	public String getEvaluation() {
		return evaluations;
	}

	public void setEvaluation(String evaluations) {
		this.evaluations = evaluations;
	}
	public String toString() {
		return  "강의 : " + lecture.getName() + ", 학생 이름 : " + student.getUser().getName() +  ", 성적 : " + grades
				+ ", 등급 : " + ranks + ", 평가 : " + evaluations + ", 이의 제기 : " + problems + ", 강의 인원 수 : " + counts; 
	}
	public String toString2() {
		return "강의 : " + lecture.getName() + ", 학생 이름 : " + student.getUser().getName() + ", 성적 : " + grades + ", 등급 : " + ranks;
	}
	
}
