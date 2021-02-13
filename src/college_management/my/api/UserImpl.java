package college_management.my.api;

import college_management.my.model.User;
import college_management.my.model.UserDatabase;

abstract public class UserImpl implements IUser {
	protected static UserDatabase db = UserDatabase.getInstance();

	@Override
	public boolean pwdupdate(String id,  String pwd) {
		return db.pwdupdate(id, pwd);
	}
	
	public boolean addressUpdate(String id, String address) {
		return db.pwdupdate(id, address);
	}
	
	public boolean emailUpdate(String id, String email) {
		return db.pwdupdate(id, email);
	}
	
	public boolean phoneUpdate(String id, String phoneNumber) {
		return db.pwdupdate(id, phoneNumber);
	}
	
	@Override
	public User read(String id) {
		return db.read(id);
	}
}
