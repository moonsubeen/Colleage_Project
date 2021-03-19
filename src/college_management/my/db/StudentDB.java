package college_management.my.db;

import javax.persistence.EntityTransaction;

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
}
