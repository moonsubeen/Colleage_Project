package college_management.my.cli;

import college_management.my.model.User;

public class CLIAuth {
	private static CLIAuth instance;
	private User loginUser;
	
	// Singleton Pattern
	public static CLIAuth getInstance() {
		if(instance == null) {
			instance = new CLIAuth();
		}
		return instance;
	}
	
	public void login(User user) {
		this.loginUser = user;
	}
	
	public boolean isLogin() {
		return (loginUser != null) ? true : false;
	}
	
	public String getLoginName() {
		return loginUser.getName();
	}
	
	public User getUser() {
		return loginUser;
	}
	
	public void logout() {
		loginUser = null;
	}
}
