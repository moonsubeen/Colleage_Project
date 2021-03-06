package college_management.my.auth;

import college_management.my.db.model.User;

public class Old_CLIAuth {
	private static Old_CLIAuth instance;
	private User loginUser;
	
	// Singleton Pattern
	public static Old_CLIAuth getInstance() {
		if(instance == null) {
			instance = new Old_CLIAuth();
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
