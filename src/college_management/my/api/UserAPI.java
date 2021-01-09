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
	private static EntityManager em = factory.createEntityManager();
	
	public User login(String id, String pwd) // 로그인
	{
		//selcet
		Query query = em.createQuery("select t from User t where id = " + id + " and pwd = " + pwd);
		List<User> resultList = query.getResultList();
		
		if(resultList.size() == 1)
			return resultList.get(0);
		else
			return null;
	}
	
	public boolean logout()
	{
		return true;
	}
	
	public boolean pwdUpdate(String pwd, String id) // 패스워드 변경 
	{
		//update
		User user = em.find(User.class, id);
		
		EntityTransaction transaction = em.getTransaction(); // 트랜잭션은 작업단위	
		transaction.begin(); 
//		Query query = em.createQuery("update User t set t.pwd = " + pwd + " where t.id = " + id);
//		Object resultList = query.getSingleResult();
//		em.persist(resultList);
		user.setPwd(pwd);
		transaction.commit();
		return true;
	}
	
	public List<User> info() // 기본 정보 출력
	{
		Query query = em.createQuery("select t from User t");
		List<User> resultList = query.getResultList();
		return resultList;
	}
	
	public User info(String id) // 기본 정보 특정 인원 출력
	{
		Query query = em.createQuery("select t from User t" + " where t.id = " + id);
		List<User> resultList = query.getResultList();
		if(resultList.size() == 1)
			return resultList.get(0);
		else
			return null;
	}
	
	public boolean RegistInfo(String role, String id, String name, String email, String nationality, String phoneNumber, String address, String residentNumber, String birthdate, String sex) // 학생 정보 입력
	{
		try{
			User user = new User();
			user.setRole(role);
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
			
			EntityTransaction transaction = em.getTransaction(); // 트랜잭션은 작업단위
			transaction.begin();
			em.persist(user);
			transaction.commit();
		} catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean infoUpdate(String id, String email, String address, String phoneNumber) // 정보 수정
	{
		User user = em.find(User.class, id);
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		user.setEmail(email);
		user.setAddress(address);
		user.setPhoneNumber(phoneNumber);
		
//		Query query_email = em.createQuery("update User t set t.email = " + email);
//		Query query_address = em.createQuery("update User t set t.address = " + address);
//		Query query_phoneNumber = em.createQuery("update User t set t.email = " + phoneNumber);
			
		transaction.commit();
		return true;
	}
}
