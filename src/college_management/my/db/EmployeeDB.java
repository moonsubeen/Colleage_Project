package college_management.my.db;

import javax.persistence.EntityTransaction;

import college_management.my.db.model.Employee;
import college_management.my.db.model.User;

public class EmployeeDB extends BaseDB{
	private static EmployeeDB instance;
	
	public static EmployeeDB getInstance() {
		if(instance == null) {
			instance = new EmployeeDB();
		}
		return instance;
	}
	
	public static Employee eregister(String id, String departments, String team) {
		try {
			Employee employee = new Employee();
			User user = em.find(User.class, id);
			employee.setUser(user);
			employee.setDepatemets(departments);
			employee.setTeam(team);
			
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.persist(employee);
			transaction.commit();
			
			return employee;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
