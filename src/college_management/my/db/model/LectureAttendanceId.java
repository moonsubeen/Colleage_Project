package college_management.my.db.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;

@Embeddable
@SuppressWarnings("serial")
public class LectureAttendanceId implements Serializable{
	
	@Column(name="lecture_code")
	private String lecture; // 강의 코드 
	
	@Column(name = "student_id")
	private String student; // 학생 번호
	
	public LectureAttendanceId() {
	}
	
	public LectureAttendanceId(String lecture, String student) {
		this.lecture = lecture;
		this.student = student;
	}
	
	public String getLecture() {
		return lecture;
	}

	public void setLecture(String lecture) {
		this.lecture = lecture;
	}

	public String getStudent() {
		return student;
	}

	public void setStudent(String student) {
		this.student = student;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}

		if (!(o instanceof LectureAttendanceId)) {
			return false;
		}
		LectureAttendanceId other = (LectureAttendanceId) o;
		return this.lecture.equals(other.lecture) && this.student.equals(other.student);
	}

	@Override
	public int hashCode() {
		return this.lecture.hashCode() ^ this.student.hashCode();
	}
}
