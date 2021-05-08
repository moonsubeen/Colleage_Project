package college_management.my.db;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import college_management.my.db.model.Lecture;
import college_management.my.db.model.Professor;
import college_management.my.db.model.Student;
import college_management.my.db.model.User;
import college_management.my.db.model.UserFamily;

public class LectureDB extends BaseDB{
	private static LectureDB instance;
	
	public static LectureDB getInstance() {
		if (instance == null) {
			instance = new LectureDB();
		}
		return instance;
	}
	
	public Lecture register(String id, String code, String name, int year, int semester, String day, 
			String time, int max_count, int point, String plan) {
		try {
			Lecture lecture = new Lecture();
			User user = em.find(User.class, id);
			Professor professor = new Professor();
			professor.setUser(user);
			lecture.setProfessor(professor);
			lecture.setCode(code);
			lecture.setName(name);
			lecture.setYear(year);
			lecture.setSemester(semester);
			lecture.setDay(day);
			lecture.setTime(time);
			lecture.setMax_count(max_count);
			lecture.setPoint(point);
			lecture.setLecturePlan(plan);
			
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.persist(lecture);
			transaction.commit();
			
			return lecture;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Lecture read(String code) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		
//		CriteriaQuery<Lecture> cQuery = criteriaBuilder.createQuery(Lecture.class);
//		Root<Lecture> from = cQuery.from(Lecture.class);
//		Predicate where = criteriaBuilder.equal(from.get("code"), code);
//		cQuery.where(where);
//		
//		Query query = em.createQuery(cQuery);
		Query query = em.createQuery("select m from Lecture m where m.code = '" + code + "'");
		List<Lecture> resultList = query.getResultList();

		if (resultList.size() == 1)
			return resultList.get(0);
		else
			return null;
	}
	
	public List<Lecture> readAll(String id) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		
//		CriteriaQuery<Lecture> cQuery = criteriaBuilder.createQuery(Lecture.class);
//		Root<Lecture> from = cQuery.from(Lecture.class);
//		Join<Lecture, Professor> join = from.join("professor");
//		Predicate where = criteriaBuilder.equal(join.get("id"), id);
//		cQuery.where(where);
//		
//		Query query = em.createQuery(cQuery);
		Query query = em.createQuery("select m from Lecture m where m.professor.user.id=" + id);
		List<Lecture> resultList = query.getResultList();

		if (resultList.size() > 0)
			return resultList;
		else
			return null;
	}
}
