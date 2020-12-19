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
	private EntityManager em = factory.createEntityManager();
	
	public int login(String id, String pwd) // 로그인
	{
		//selcet
		Query query = em.createQuery("select t from User t where id = " + id + "and pwd = " + pwd);
        Object resultList = query.getSingleResult();
        if(resultList.equals(id) && resultList.equals(pwd))
        	return 0;
        else
        	return -1;
	}
	
	public String pwdUpdate(String pwd) // 패스워드 변경 
	{
		//update
		Query query2 = em.createQuery("update User set pwd = ");
        Object resultList2 = query2.getSingleResult();
		return null;
	}
	
	public String info() // 기본 정보 출력
	{
		return null;
	}
	
	public String infoUpdate() // 정보 수정
	{
		return null;
	}
}
