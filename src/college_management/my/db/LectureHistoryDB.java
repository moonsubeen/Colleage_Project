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
import college_management.my.db.model.LectureHistoryID;
import college_management.my.db.model.QLectureHistory;
import college_management.my.db.model.Student;

public class LectureHistoryDB extends BaseDB{
	private static LectureHistoryDB instance;
	static int count = 0;
	
	public static LectureHistoryDB getInstance() {
		if (instance == null) {
			instance = new LectureHistoryDB();
		}
		return instance;
	}
	
	public static void register(String lecture_code, String student_id, int grade, String ranks, String evaluation, String problem) {
		EntityTransaction transaction = em.getTransaction();
//		count++;
		transaction.begin();
		em.createNativeQuery("INSERT INTO lecturehistory (lecture_code, student_id, grade, ranks, evaluation, problem, count) VALUES (?,?,?,?,?,?,?)")
		.setParameter(1, lecture_code).setParameter(2, student_id).setParameter(3, grade).setParameter(4, "").setParameter(5, "").setParameter(6, "").setParameter(7, 0)
		.executeUpdate();
		transaction.commit();
	}
	
	public static void grade(String code, String id, int grade, String ranks) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.createNativeQuery("update lecturehistory m set m.grade = :grade, m.ranks =:ranks where m.lecture_code = :code and m.student_id = :id")
		.setParameter("grade", grade).setParameter("ranks", ranks).setParameter("code", code).setParameter("id", id).executeUpdate();
		transaction.commit();
	}
	
	public static void problem(String code, String id, String problem) {	
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.createNativeQuery("update lecturehistory m set m.problem = :problem where m.lecture_code = :code and m.student_id = :id")
		.setParameter("problem", problem).setParameter("code", code).setParameter("id", id).executeUpdate();
		transaction.commit();
	}
	
	public static void evaluation(String code, String id, String evaluation) {	
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.createNativeQuery("update lecturehistory m set m.evaluation = :evaluation where m.lecture_code = :code and m.student_id = :id")
		.setParameter("evaluation", evaluation).setParameter("code", code).setParameter("id", id).executeUpdate();
		transaction.commit();
	}
	
	public static void check(String id, String code, int grade, String ranks) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.createNativeQuery("update lecturehistory m set m.grade = :evaluation where m.lecture_code = :code and m.student_id = :id")
		.setParameter("evaluation", grade).setParameter("code", code).setParameter("id", id).executeUpdate();
		transaction.commit();
	}
	
//	public List<LectureHistory> read(String id) {
//		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
//		
//		Query query = em.createQuery("select m from LectureHistory m where m.student.user.id = " + id);
//		List<LectureHistory> resultList = query.getResultList();
//
//		if (resultList.size() > 0)
//			return resultList;
//		else
//			return null;
//	}
//	
	public static List<LectureHistory> read(String id) {
		QLectureHistory LectureHistory = QLectureHistory.lectureHistory;
		
		List<LectureHistory> result = new JPAQuery<LectureHistory>(em).from(LectureHistory).where(LectureHistory.student.user.id.eq(id)).fetch();
		return result;
	}
	
	public static List<LectureHistory> readAll() {
		QLectureHistory LectureHistory = QLectureHistory.lectureHistory;
		
		List<LectureHistory> result = new JPAQuery<LectureHistory>(em).from(LectureHistory).fetch();
		return result;
	}
	
//	public List<LectureHistory> readAll() {
//		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
//		
//		Query query = em.createQuery("select m from LectureHistory m");
//		List<LectureHistory> resultList = query.getResultList();
//
//		if (resultList.size() > 0)
//			return resultList;
//		else
//			return null;
//	}
}
