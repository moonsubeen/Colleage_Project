package college_management.my.api;

import javax.persistence.EntityManagerFactory;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import college_management.my.model.User;

public class UserAPI {
	private static final String PERSISTENCE_UNIT_NAME = "h2";
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);;
	
	public int login(String id, String pwd) // 로그인
	{
		//selcet
		EntityManager em = factory.createEntityManager();
		Query query = em.createQuery("select t from User t where id = " + id + "and pwd = " + pwd);
		Object resultList = query.getSingleResult();
        em.close();
        if(resultList.equals(id) && resultList.equals(pwd))
        	return 0;
        else
        	return -1;
	}
	
	public static void pwdUpdate(String pwd) // 패스워드 변경 
	{
		//update
		EntityManager em = factory.createEntityManager();
		EntityTransaction transaction = em.getTransaction(); // 트랜잭션은 작업단위
		if(pwd.length() != 8)
		{
			pwd = "12345asd";
		}
			
		transaction.begin(); 
		Query query = em.createQuery("update User t set t.pwd = " + pwd);
		Object resultList = query.getSingleResult();
		em.persist(resultList);
		transaction.commit();
		em.close();    
	}
	
	public static void info() // 기본 정보 출력
	{
		EntityManager em = factory.createEntityManager();
		Query query = em.createQuery("select t from User t");
		List<User> resultList = query.getResultList();
		em.close();
	}
	
	public static void info(String id) // 기본 정보 특정 인원 출력
	{
		EntityManager em = factory.createEntityManager();
		Query query = em.createQuery("select t from User t" + "where t = " + id);
		List<User> resultList = query.getResultList();
		em.close();
	}
	
	public static void infoUpdate(String email, String address, String phoneNumber) // 정보 수정
	{
		EntityManager em = factory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		Query query_email = em.createQuery("update User t set t.email = " + email);
		Query query_address = em.createQuery("update User t set t.address = " + address);
		Query query_phoneNumber = em.createQuery("update User t set t.email = " + phoneNumber);
			
		transaction.commit();
		    
        em.close();
	}
}
