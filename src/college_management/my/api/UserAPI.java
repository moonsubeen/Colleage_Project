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
	
	public int pwdUpdate(String pwd) // 패스워드 변경 
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
        
		return 1;
	}
	
	public String info() // 기본 정보 출력
	{
		EntityManager em = factory.createEntityManager();
		Query query = em.createQuery("select t from User t");
		List<User> resultList = query.getResultList();
		for (User result : resultList) {
//            System.out.println(result.toString());
        }
		em.close();
		return null;
	}
	
	public String infoUpdate() // 정보 수정
	{
		return null;
	}
}
