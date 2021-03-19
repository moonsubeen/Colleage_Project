package college_management.my.db;

import javax.persistence.EntityTransaction;

import college_management.my.db.model.Lecture;
import college_management.my.db.model.Professor;
import college_management.my.db.model.Student;
import college_management.my.db.model.User;

public class ProfessorDB extends BaseDB{
	private static ProfessorDB instance;
	
	public static ProfessorDB getInstance() {
		if(instance == null) {
			instance = new ProfessorDB();
		}
		return instance;
	}
	
	public Professor pregister(String id, String faculty, String department) {
		try {
			Professor professor = new Professor();
			User user = em.find(User.class, id);
			professor.setUser(user);
			professor.setFaculty(faculty);
			professor.setDepartment(department);
			
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.persist(professor);
			transaction.commit();
			
			return professor;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Lecture lregister(String id, String code, String name, int point, String plan) {
		try {
			Lecture lecture = new Lecture();
			User user = em.find(User.class, id);
			lecture.setUser(user);
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
