package college_management.my.api;

import javax.persistence.EntityManagerFactory;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import college_management.my.model.Student;
import college_management.my.model.User;

public class EmployeeAPI {	
	private static final String PERSISTENCE_UNIT_NAME = "h2";
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	private static EntityManager em = factory.createEntityManager();
	
	public boolean studentInfo(String id, String name, String email, String nationality, String phoneNumber, String address, String residentNumber, String birthdate, String sex) // 학생 정보 입력
	{
		try{
			User user = new User();
		
			EntityTransaction transaction = em.getTransaction(); // 트랜잭션은 작업단위
			transaction.begin();
			user.setId(id);
			user.getPwd();
			user.setName(name);
			user.setEmail(email);
			user.setNationality(nationality);
			user.setPhoneNumber(phoneNumber);
			user.setAddress(address);
			user.setResidentNumber(residentNumber);
			user.setBirthdate(birthdate);
			user.setSex(sex);
			
			em.persist(user);
			
			transaction.commit();
		} catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static void professorInfo() // 교수 정보 입력
	{

	}
	
	public static void lectureMake(String lecturePlan, String lectureCode) // 강의개설
	{
		
	}
}
