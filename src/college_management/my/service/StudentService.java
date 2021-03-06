package college_management.my.service;

import college_management.my.db.StudentDB;

public class StudentService {
	private static StudentService instance;
	protected static StudentDB db = StudentDB.getInstance();

	public static StudentService getInstance() {
		if (instance == null) {
			instance = new StudentService();
		}
		return instance;
	}

	public boolean sregister(String major, String campus) {
		return db.sregister(major, campus);
	}
}
