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
	
	public static LectureHistoryDB getInstance() {
		if (instance == null) {
			instance = new LectureHistoryDB();
		}
		return instance;
	}
	
	public LectureHistory register(String code, String id, int grade, String rank, String problem, String evaluation, String count) {
		try {
			Lecture lecture = em.find(Lecture.class, code);
			Student student = em.find(Student.class, id);
			LectureHistory history = new LectureHistory(); 
//			history.setLecture(lecture);
//			history.setStudent(student);
			history.setGrade(grade);
			history.setRank(rank);
			history.setProblem(problem);
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
	
	public LectureHistory read(String id) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		
		CriteriaQuery<LectureHistory> cQuery = criteriaBuilder.createQuery(LectureHistory.class);
		Root<LectureHistory> from = cQuery.from(LectureHistory.class);
		Predicate where = criteriaBuilder.equal(from.get("id"), id);
		cQuery.where(where);
		
		Query query = em.createQuery(cQuery);
		List<LectureHistory> resultList = query.getResultList();

		if (resultList.size() == 1)
			return resultList.get(0);
		else
			return null;
	}
}
