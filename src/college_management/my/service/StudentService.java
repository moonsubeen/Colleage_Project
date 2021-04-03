package college_management.my.service;

import college_management.my.api.config.Permission;
import college_management.my.db.DisabilityDB;
import college_management.my.db.SoldierDB;
import college_management.my.db.StudentDB;
import college_management.my.db.model.Student;
import college_management.my.db.model.UserDisability;
import college_management.my.db.model.UserSoldier;
import college_management.my.db.model.User;

public class StudentService {
	private static StudentService instance;
	protected static StudentDB db = StudentDB.getInstance();
	protected static DisabilityDB ddb = DisabilityDB.getInstance();
	protected static SoldierDB sdb = SoldierDB.getInstance();

	public static StudentService getInstance() {
		if (instance == null) {
			instance = new StudentService();
		}
		return instance;
	}
	
	public boolean register(String id, String major, String campus) {
		Student student = db.sregister(id, major, campus);
		if(student == null)
			return false;
		return true;
	}
	
	public Student read(String id) {
		return db.read(id);
	}
}
