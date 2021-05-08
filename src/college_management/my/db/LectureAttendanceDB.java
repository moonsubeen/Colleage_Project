package college_management.my.db;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;

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
	
	public LectureAttendance register(String id, String code, int month, String day, String attendance) {
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
			em.persist(attendances);
			transaction.commit();
			
			return attendances;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<LectureAttendance> readAll(String id) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		
		Query query = em.createQuery("select m from LectureAttendance m where m.student.user.id=" + id);
		List<LectureAttendance> resultList = query.getResultList();

		if (resultList.size() > 0)
			return resultList;
		else
			return null;
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
