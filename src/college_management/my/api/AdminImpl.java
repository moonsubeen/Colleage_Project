package college_management.my.api;

import java.util.List;

import college_management.my.model.User;

public class AdminImpl extends UserImpl implements IAdmin {
	@Override
	public boolean register(String id, String name, String email, String nationality, String phoneNumber, String address, String residentNumber, String birthdate, String sex, Permission role) {
		return db.register(id, name, email, nationality, phoneNumber, address, residentNumber, birthdate, sex, role);
	}

	@Override
	public List<User> readAll() {
		return db.readAll();
	}
}
