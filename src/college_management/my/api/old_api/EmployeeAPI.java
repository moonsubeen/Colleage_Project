package college_management.my.api.old_api;

import javax.persistence.EntityManagerFactory;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import college_management.my.db.model.Student;
import college_management.my.db.model.User;

public class EmployeeAPI extends UserAPI{
//	
//	@Override
//	public boolean register(String id, String name, String password) {
//		try {
//			User user = new User();
//			user.setId(id);
//			user.setName(name);
//			user.setPwd(password);
//			user.setRole("employee");
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
//	public boolean studentInfo(String id, String name, String email, String nationality, String phoneNumber, String address, String residentNumber, String birthdate, String sex) // 학생 정보 입력
//	{
//		try{
//			User user = new User();
//		
//			EntityTransaction transaction = em.getTransaction(); // 트랜잭션은 작업단위
//			transaction.begin();
//			user.setId(id);
//			user.getPwd();
//			user.setName(name);
//			user.setEmail(email);
//			user.setNationality(nationality);
//			user.setPhoneNumber(phoneNumber);
//			user.setAddress(address);
//			user.setResidentNumber(residentNumber);
//			user.setBirthdate(birthdate);
//			user.setSex(sex);
//			
//			em.persist(user);
//			
//			transaction.commit();
//		} catch(Exception e){
//			e.printStackTrace();
//			return false;
//		}
//		return true;
//	}
	
	public static void professorInfo() // 교수 정보 입력
	{

	}
	
	public static void lectureMake(String lecturePlan, String lectureCode) // 강의개설
	{
		
	}
}
