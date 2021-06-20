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

import college_management.my.db.model.QStudent;
import college_management.my.db.model.QUser;
import college_management.my.db.model.Student;
import college_management.my.db.model.User;

public class StudentDB extends BaseDB{
	private static StudentDB instance;
	
	public static StudentDB getInstance() {
		if (instance == null) {
			instance = new StudentDB();
		}
		return instance;
	}
	
	public Student sregister(String id, String major, String campus) {
		try {
			Student student = new Student();
			User user = em.find(User.class, id);
			student.setUser(user);
			student.setMajor(major);
			student.setCampus(campus);
			
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.persist(student);
			transaction.commit();
			
			return student;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Student read(String id) {
		QStudent student = QStudent.student;
		Student result = new JPAQuery<Student>(em).from(student).where(student.user.id.eq(id)).fetchOne();
		return result;
	}
}
