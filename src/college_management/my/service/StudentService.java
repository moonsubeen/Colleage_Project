package college_management.my.service;

import college_management.my.api.config.Permission;
import college_management.my.db.StudentDB;
import college_management.my.db.model.Student;
import college_management.my.db.model.User;

public class StudentService {
	private static StudentService instance;
	protected static StudentDB db = StudentDB.getInstance();

	public static StudentService getInstance() {
		if (instance == null) {
			instance = new StudentService();
		}
		return instance;
	}
	
	public boolean sregister(String id, String major, String campus) {
		Student student = db.sregister(id, major, campus);
		if(student == null)
			return false;
		return true;
	}
}
