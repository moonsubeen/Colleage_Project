package college_management.my.service;

import college_management.my.db.EmployeeDB;
import college_management.my.db.model.Employee;

public class EmployeeService {
	private static EmployeeService instance;
	protected static EmployeeDB db = EmployeeDB.getInstance();
	
	public static EmployeeService getInstance() {
		if (instance == null) {
			instance = new EmployeeService();
		}
		return instance;
	}
	
	public boolean register(String id, String departments, String team) {
		Employee employee = db.eregister(id, departments, team);
		if(employee == null)
			return false;
		return true;
	}
}
