package college_management.my.auth;

import college_management.my.api.config.Permission;
import college_management.my.db.model.Student;
import college_management.my.db.model.User;
import college_management.my.db.StudentDB;
import college_management.my.db.UserDB;

public class UserAuth {
	private static UserAuth instance;
	private User user;
	private static UserDB db = UserDB.getInstance();
	
	// Singleton Pattern
	public static UserAuth getInstance() {
		if(instance == null) {
			instance = new UserAuth();
		}
		return instance;
	}
	
	public boolean login(String id, String pwd) {
		// 로그인 사용자 준비
		User loginUser = db.login(id, pwd);
		if (loginUser == null) {
			System.out.println("login fail");
			return false;
		}
		user = loginUser;
		return true;
	}
	
	public boolean isLogin() {
		return (user != null) ? true : false;
	}

	public boolean hasAdminPermission() {
		Permission role = user.getRole();
		if (Permission.Admin.equals(role) || Permission.Employee.equals(role)) {
			return true;
		}
		return false;
	}
	
	public boolean hasProfessorPermission() {
		Permission role = user.getRole();
		if (Permission.Professor.equals(role)) {
			return true;
		}
		return false;
	}
	
	public boolean hasStudentPermission() {
		Permission role = user.getRole();
		if (Permission.Student.equals(role)) {
			return true;
		}
		return false;
	}

	public String getLoginName() {
		return user.getRole() + ":" + user.getId() + "(" + user.getName() + ")";
	}

	public User getUser() {
		return user;
	}
	
	public boolean logout() {
		user = null;
		return true;
	}

}