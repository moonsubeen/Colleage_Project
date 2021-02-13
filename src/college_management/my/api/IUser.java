package college_management.my.api;

import java.util.List;

import college_management.my.model.User;

public interface IUser {
	// 회원정보 수정
	boolean pwdupdate(String id, String pwd); // 비밀번호 수정
	boolean addressUpdate(String id, String address); // 주소 수정
	boolean emailUpdate(String id, String email); // 이메일 수정
	boolean phoneUpdate(String id, String phoneNumber); // 전화번호 수정
	
	// 회원정보 읽기
	User read(String id);
}
