package college_management.my.db;

import javax.persistence.EntityTransaction;

import college_management.my.db.model.Lecture;
import college_management.my.db.model.Professor;
import college_management.my.db.model.User;

public class LectureDB extends BaseDB{
	private static LectureDB instance;
	
	public static LectureDB getInstance() {
		if (instance == null) {
			instance = new LectureDB();
		}
		return instance;
	}
	
	public Lecture lregister(String id, String code, String name, int point, String plan) {
		try {
			Lecture lecture = new Lecture();
			User user = em.find(User.class, id);
			Professor professor = new Professor();
			professor.setUser(user);
			lecture.setProfessor(professor);
			lecture.setLectureCode(code);
			lecture.setName(name);
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
}
