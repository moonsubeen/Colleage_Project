package college_management.my.api;

import javax.persistence.EntityTransaction;

import college_management.my.model.User;

public class ProfessorAPI extends UserAPI{
	
//	@Override
//	public boolean register(String id, String name, String password) {
//		try {
//			User user = new User();
//			user.setId(id);
//			user.setName(name);
//			user.setPwd(password);
//			user.setRole("professor");
//
//			EntityTransaction transaction = em.getTransaction();
//			transaction.begin();
//			em.persist(user);
//			transaction.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			return false;
//		}
//		return true;
//	}
//	
//	public String lectureSubmit() // 강의 개설 신청
//	{
//		return null;
//	}
//	
//	public int grade() // 성적 입력
//	{
//		return 0;
//	}
//	
//	public int attendance() // 출석 입력
//	{
//		return 0;
//	}
}
