package college_management.my.db;

import javax.persistence.EntityTransaction;

import college_management.my.db.model.Lecture;
import college_management.my.db.model.LectureAttendance;
import college_management.my.db.model.Professor;
import college_management.my.db.model.Student;

public class LectureAttendanceDB extends BaseDB{
	private static LectureAttendanceDB instance;
	
	public static LectureAttendanceDB getInstance() {
		if (instance == null) {
			instance = new LectureAttendanceDB();
		}
		return instance;
	}
	
	public LectureAttendance register(String id, String code, String attendance) {
		try {
			Lecture lecture = em.find(Lecture.class, code);
			Student student = em.find(Student.class, id);
			LectureAttendance attendances = new LectureAttendance();
			attendances.setLecture(lecture);
			attendances.setStudent(student);
			attendances.setAttendance(attendance);
			
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.persist(lecture);
			transaction.commit();
			
			return attendances;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
