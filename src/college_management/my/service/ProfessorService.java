package college_management.my.service;

import college_management.my.db.ProfessorDB;
import college_management.my.db.UserDB;
import college_management.my.db.model.Professor;
import college_management.my.db.model.Student;

public class ProfessorService {
	private static ProfessorService instance;
	protected static ProfessorDB db = ProfessorDB.getInstance();
	
	public static ProfessorService getInstance() {
		if (instance == null) {
			instance = new ProfessorService();
		}
		return instance;
	}
	
	public boolean pregister(String id, String faculty, String department) {
		Professor student = db.pregister(id, faculty, department);
		if(student == null)
			return false;
		return true;
	}
}
