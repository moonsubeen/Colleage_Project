package college_management.my.db;

import javax.persistence.EntityTransaction;

import college_management.my.db.model.Student;

public class StudentDB extends BaseDB{
	private static StudentDB instance;
	
	public static StudentDB getInstance() {
		if (instance == null) {
			instance = new StudentDB();
		}
		return instance;
	}
	
	public boolean sregister(String major, String campus) {
		try {
			Student student = new Student();
			student.setMajor(major);
			student.setCampus(campus);
			
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.persist(student);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
