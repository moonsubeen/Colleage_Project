package college_management.my.db;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import college_management.my.db.model.Lecture;
import college_management.my.db.model.LectureAttendance;
import college_management.my.db.model.LectureHistory;
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
	
	public LectureAttendance register(String id, String code, int month, int day, String attendance) {
		try {
			Lecture lecture = em.find(Lecture.class, code);
			Student student = em.find(Student.class, id);
			LectureAttendance attendances = new LectureAttendance();
			attendances.setLecture(lecture);
			attendances.setStudent(student);
			attendances.setMonth(month);
			attendances.setDay(day);
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
	
	public LectureAttendance count() {
		Query query = em.createQuery("select count(m) from LectureAttendance m where m.attendance = 결석");
		List<LectureAttendance> resultList = query.getResultList();

		if (resultList.size() == 1)
			return resultList.get(0);
		else
			return null;
	}
}
