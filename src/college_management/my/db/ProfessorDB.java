package college_management.my.db;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.querydsl.jpa.impl.JPAQuery;

import college_management.my.db.model.Lecture;
import college_management.my.db.model.Professor;
import college_management.my.db.model.QProfessor;
import college_management.my.db.model.QUser;
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
	
	public Professor read(String id) {
		QProfessor professor = QProfessor.professor;
		Professor result = new JPAQuery<Professor>(em).from(professor).where(professor.user.id.eq(id)).fetchOne();
		return result;
	}
	
}
