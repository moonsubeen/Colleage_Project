package college_management.my.api;

import javax.persistence.EntityTransaction;

import college_management.my.model.User;

public class StudentAPI extends UserAPI{
//	
//	@Override
//	public boolean register(String id, String name, String password) {
//		try {
//			User user = new User();
//			user.setId(id);
//			user.setName(name);
//			user.setPwd(password);
//			user.setRole("student");
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
//	public int lectureApplication(String lectureCode) // 강의 신청
//	{
//		return 0;
//	}
//	
//	public int lectureAttendaceCheck() // 강의 출석 조회
//	{
//		return 0;
//	}
//	
//	public String lectureEvaluation() // 강의 평가
//	{
//		return null;
//	}
//	
//	public String gradeApeal() // 성적 이의신청
//	{
//		return null;
//	}
}
