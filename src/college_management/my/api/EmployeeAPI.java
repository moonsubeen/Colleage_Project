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
	
	public String studentInfo() // 학생 정보 입력
	{	
		EntityManager em = factory.createEntityManager();
		User user = new User();
		
		EntityTransaction transaction = em.getTransaction(); // 트랜잭션은 작업단위
	    transaction.begin(); 
	    
	    user.setId("");
	    user.getPwd();
	    user.setName("");
	    user.setEmail("");
	    user.setNationality("");
	    user.setPhoneNumber("");
	    user.setAddress("");
	    user.setResidentNumber("");
	    user.setBirthdate("");
	    user.setSex("");
	    
	    em.persist(user);
	    
	    transaction.commit();
	    em.close();
	    
		return null;
	}
	
	public String professorInfo() // 교수 정보 입력
	{
		return null;
	}
	
	public String lectureMake(String lecturePlan, String lectureCode) // 강의개설
	{
		return null;
	}
}
