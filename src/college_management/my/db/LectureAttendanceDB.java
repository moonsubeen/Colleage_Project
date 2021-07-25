package college_management.my.db;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.querydsl.jpa.impl.JPAQuery;

import college_management.my.db.model.Lecture;
import college_management.my.db.model.LectureAttendance;
import college_management.my.db.model.LectureHistory;
import college_management.my.db.model.Professor;
import college_management.my.db.model.QLectureAttendance;
import college_management.my.db.model.QLectureHistory;
import college_management.my.db.model.Student;
import college_management.my.db.model.User;

public class LectureAttendanceDB extends BaseDB{
	private static LectureAttendanceDB instance;
	
	public static LectureAttendanceDB getInstance() {
		if (instance == null) {
			instance = new LectureAttendanceDB();
		}
		return instance;
	}
	
	public LectureAttendance register(String id, String code, String month, String day, String attendance) {
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
	
	public static List<LectureAttendance> check(String id, String code) {
		QLectureAttendance LectureAttendance = QLectureAttendance.lectureAttendance;
		
		List<LectureAttendance> result = new JPAQuery<LectureAttendance>(em).from(LectureAttendance).where(LectureAttendance.student.user.id.eq(id).and(LectureAttendance.lecture.code.eq(code))).fetch();
		return result;
	}
	
	public static List<LectureAttendance> readAll(String id) {
		QLectureAttendance LectureAttendance = QLectureAttendance.lectureAttendance;
		
		List<LectureAttendance> result = new JPAQuery<LectureAttendance>(em).from(LectureAttendance).where(LectureAttendance.student.user.id.eq(id)).fetch();
		return result;
	}
	
	public static List<LectureAttendance> readAll2() {
		QLectureAttendance LectureAttendance = QLectureAttendance.lectureAttendance;
		
		List<LectureAttendance> result = new JPAQuery<LectureAttendance>(em).from(LectureAttendance).fetch();
		return result;
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
