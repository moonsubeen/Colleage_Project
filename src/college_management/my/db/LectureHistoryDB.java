package college_management.my.db;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAUpdateClause;

import college_management.my.db.model.Lecture;
import college_management.my.db.model.LectureAttendance;
import college_management.my.db.model.LectureHistory;
import college_management.my.db.model.LectureHistoryID;
import college_management.my.db.model.QLecture;
import college_management.my.db.model.QLectureHistory;
import college_management.my.db.model.QProfessor;
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
		em.createNativeQuery("INSERT INTO lecturehistory (lecture_code, student_id, grade, ranks, evaluation, problem) VALUES (?,?,?,?,?,?)")
		.setParameter(1, lecture_code).setParameter(2, student_id).setParameter(3, grade).setParameter(4, "").setParameter(5, "").setParameter(6, "")
		.executeUpdate();
		transaction.commit();
	}
	
	public static void grade(String code, String id, int grade, String ranks) {
		QLectureHistory LectureHistory = QLectureHistory.lectureHistory;
		em.getTransaction().begin();
		JPAUpdateClause update = new JPAUpdateClause(em, LectureHistory);
		update.set(LectureHistory.grades, grade);
		update.set(LectureHistory.ranks, ranks);
		update.where(LectureHistory.lecture.code.eq(code).and(LectureHistory.student.user.id.eq(id))).execute();
		em.getTransaction().commit();
		em.clear();
	}
	
	public static void problem(String code, String id, String problem) {	
		QLectureHistory LectureHistory = QLectureHistory.lectureHistory;
		em.getTransaction().begin();
		JPAUpdateClause update = new JPAUpdateClause(em, LectureHistory);
		update.set(LectureHistory.problems, problem);
		update.where(LectureHistory.lecture.code.eq(code).and(LectureHistory.student.user.id.eq(id))).execute();
		em.getTransaction().commit();
		em.clear();
	}
	
	public static void evaluation(String code, String id, String evaluation) {	
		QLectureHistory LectureHistory = QLectureHistory.lectureHistory;
		em.getTransaction().begin();
		JPAUpdateClause update = new JPAUpdateClause(em, LectureHistory);
		update.set(LectureHistory.evaluations, evaluation);
		update.where(LectureHistory.lecture.code.eq(code).and(LectureHistory.student.user.id.eq(id))).execute();
		em.getTransaction().commit();
		em.clear();
	}
	
	public static List<LectureHistory> read(String id) {
		QLectureHistory LectureHistory = QLectureHistory.lectureHistory;
		
		List<LectureHistory> result = new JPAQuery<LectureHistory>(em).from(LectureHistory).where(LectureHistory.student.user.id.eq(id)).fetch();
		return result;
	}
	
	public static List<LectureHistory> hread(String code) {
		QLectureHistory LectureHistory = QLectureHistory.lectureHistory;
		
		List<LectureHistory> result = new JPAQuery<LectureHistory>(em).from(LectureHistory).where(LectureHistory.lecture.code.eq(code)).fetch();
		return result;
	}
	
	public static List<LectureHistory> read2(String id) {
		QLectureHistory LectureHistory = QLectureHistory.lectureHistory;
		QLecture lecture = QLecture.lecture;
//		QProfessor professor = QProfessor.professor;
//		
//		List<Lecture> lece = new ArrayList<Lecture>();
//		List<Lecture> result = new JPAQuery<Lecture>(em).from(lecture).where(lecture.professor.user.id.eq(id)).fetch();
//		for(int i = 1; i <= result.size(); i++)
//			lece.add(result.get(i));
				
//		List<LectureHistory> result2 = new JPAQuery<LectureHistory>(em).from(LectureHistory).where(LectureHistory.lecture.eq(result.get(1))).fetch();
		
		Query query = em.createQuery("select u from LectureHistory u left join u.lecture t where u.lecture.professor.user.id = '" + id + "'");
		
		List<LectureHistory> result = query.getResultList();
		return result;
	}
	
	public static LectureHistory read3(String code, String id) {
		QLectureHistory LectureHistory = QLectureHistory.lectureHistory;
		
		LectureHistory result = new JPAQuery<LectureHistory>(em).from(LectureHistory).where(LectureHistory.lecture.code.eq(code).and(LectureHistory.student.user.id.eq(id))).fetchOne();
		return result;
	}
	
	public static List<LectureHistory> readAll() {
		QLectureHistory LectureHistory = QLectureHistory.lectureHistory;
		
		List<LectureHistory> result = new JPAQuery<LectureHistory>(em).from(LectureHistory).fetch();
		return result;
	}
}
