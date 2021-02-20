package college_management.my.api;

import java.util.List;

import college_management.my.model.User;

public interface IUser {
	// 회원정보 수정
	boolean update(String id, String pwd, String name, String email, String address, String phoneNumber); // 비밀번호 수정
	
	// 회원정보 읽기
	User read(String id);
}
