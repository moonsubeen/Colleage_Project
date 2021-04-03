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
	
	public Professor register(String id, String faculty, String department) {
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
}
