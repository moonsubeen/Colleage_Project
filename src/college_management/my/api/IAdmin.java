package college_management.my.api;

import java.util.List;

import college_management.my.model.User;

public interface IAdmin {
	// 회원 등록
	boolean register(String id, String name, String email, String nationality, String phoneNumber, String address, String residentNumber, String birthdate, String sex, Permission role);

	// 모든 회원정보 읽기
	List<User> readAll();
}
