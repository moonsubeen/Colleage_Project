package college_management.my.api;

import college_management.my.model.User;
import college_management.my.model.UserDatabase;

abstract public class UserImpl implements IUser {
	protected static UserDatabase db = UserDatabase.getInstance();

	@Override
	public boolean update(String id,  String pwd, String name, String email ,String address, String phoneNumber) {
		return db.update(id, pwd, name, email, address, phoneNumber);
	}
	@Override
	public User read(String id) {
		return db.read(id);
	}
}
