package college_management.my.db;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import college_management.my.db.model.Lecture;
import college_management.my.db.model.LectureHistory;
import college_management.my.db.model.Student;

public class LectureHistoryDB extends BaseDB{
	private static LectureHistoryDB instance;
	int count = 0;
	
	public static LectureHistoryDB getInstance() {
		if (instance == null) {
			instance = new LectureHistoryDB();
		}
		return instance;
	}
	
	public LectureHistory register(String code, String id, int grade, String rank) {
		try {
			Lecture lecture = em.find(Lecture.class, code);
			Student student = em.find(Student.class, id);
			LectureHistory history = new LectureHistory(); 
			count++;
			history.setLecture(lecture);
			history.setStudent(student);
			history.setGrade(grade);
			history.setRank(rank);
			history.setCount(count);
			history.setProblem("");
			history.setEvaluation("");
			
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.persist(history);
			transaction.commit();
			
			return history;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public LectureHistory problem(String code, String id, String problem) {
		try {
			Lecture lecture = em.find(Lecture.class, code);
			Student student = em.find(Student.class, id);
			LectureHistory history = new LectureHistory();
			history.setProblem(problem);
			
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.persist(history);
			transaction.commit();
			
			return history;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public LectureHistory evaluation(String code, String id, String evaluation) {
		try {
			Lecture lecture = em.find(Lecture.class, code);
			Student student = em.find(Student.class, id);
			LectureHistory history = new LectureHistory();
			history.setEvaluation(evaluation);
			
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.persist(history);
			transaction.commit();
			
			return history;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean check(String id, String code) {
			Lecture lecture = em.find(Lecture.class, code);
			Student student = em.find(Student.class, id);
			LectureHistory history = new LectureHistory();
			if(history.getEvaluation() == null)
				return false;
			return true;
	}
	
	public LectureHistory read(String code) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		
		CriteriaQuery<LectureHistory> cQuery = criteriaBuilder.createQuery(LectureHistory.class);
		Root<LectureHistory> from = cQuery.from(LectureHistory.class);
		Predicate where = criteriaBuilder.equal(from.get("code"), code);
		cQuery.where(where);
		
		Query query = em.createQuery(cQuery);
//		Query query = em.createQuery("select m from LectureHistory m where m.lecture.code = '" + code + "'");
		List<LectureHistory> resultList = query.getResultList();

		if (resultList.size() == 1)
			return resultList.get(0);
		else
			return null;
	}
}
