package college_management.my.api;

import javax.persistence.EntityManagerFactory;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import college_management.my.model.User;

public class UserAPI{
//	private static final String PERSISTENCE_UNIT_NAME = "h2";
//	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);;
//	protected static EntityManager em = factory.createEntityManager();
//	
//	@SuppressWarnings("unchecked")
//	@Override
//	public User login(String id, String pwd) {
//		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
//		
//		CriteriaQuery<User> cQuery = criteriaBuilder.createQuery(User.class);
//		Root<User> from = cQuery.from(User.class);
//		Predicate where1 = criteriaBuilder.equal(from.get("id"), id);
//		Predicate where2 = criteriaBuilder.equal(from.get("password"), pwd);
//		Predicate whereFinal = criteriaBuilder.and(where1, where2);
//		cQuery.where(whereFinal);
//		
//		Query query = em.createQuery(cQuery);
//		List<User> resultList = query.getResultList();
//
//		if (resultList.size() == 1) {
//			return resultList.get(0);
//		}
//		else
//			return null;
//	}
	
//	public User login(String id, String pwd) // 로그인
//	{
//		//selcet
//		Query query = em.createQuery("select t from User t where id = " + id + " and pwd = " + pwd);
//		List<User> resultList = query.getResultList();
//		
//		if(resultList.size() == 1)
//			return resultList.get(0);
//		else
//			return null;
//	}
	
//	@Override
//	public boolean logout() {
//		return true;
//	}
//	
//	public boolean logout()
//	{
//		return true;
//	}
	
//	public boolean pwdUpdate(String pwd, String id) // 패스워드 변경 
//	{
//		//update
//		User user = em.find(User.class, id);
//		
//		EntityTransaction transaction = em.getTransaction(); // 트랜잭션은 작업단위	
//		transaction.begin(); 
//		Query query = em.createQuery("update User t set t.pwd = " + pwd + " where t.id = " + id);
//		Object resultList = query.getSingleResult();
//		em.persist(resultList);
//		user.setPwd(pwd);
//		transaction.commit();
//		return true;
//	}
	
//	@Override
//	public List<User> readAll() {
//		return null;
//	}
//	
//	public List<User> info() // 기본 정보 출력
//	{
//		Query query = em.createQuery("select t from User t");
//		List<User> resultList = query.getResultList();
//		return resultList;
//	}
	
//	@SuppressWarnings("unchecked")
//	@Override
//	public User read(String id) {
//		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
//		
//		CriteriaQuery<User> cQuery = criteriaBuilder.createQuery(User.class);
//		Root<User> from = cQuery.from(User.class);
//		Predicate where = criteriaBuilder.equal(from.get("id"), id);
//		cQuery.where(where);
//		
//		Query query = em.createQuery(cQuery);
//		List<User> resultList = query.getResultList();
//
//		if (resultList.size() == 1)
//			return resultList.get(0);
//		else
//			return null;
//	}
	
//	public User info(String id) // 기본 정보 특정 인원 출력
//	{
//		Query query = em.createQuery("select t from User t" + " where t.id = " + id);
//		List<User> resultList = query.getResultList();
//		if(resultList.size() == 1)
//			return resultList.get(0);
//		else
//			return null;
//	}
	
//	@Override
//	public boolean register(String id, String name, String password) {
//		// TODO Auto-generated method stub
//		return false;
//	}
	
//	public boolean RegistInfo(String role, String id, String name, String email, String nationality, String phoneNumber, String address, String residentNumber, String birthdate, String sex) // 학생 정보 입력
//	{
//		try{
//			User user = new User();
//			user.setRole(role);
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
//			EntityTransaction transaction = em.getTransaction(); // 트랜잭션은 작업단위
//			transaction.begin();
//			em.persist(user);
//			transaction.commit();
//		} catch(Exception e){
//			e.printStackTrace();
//			return false;
//		}
//		return true;
//	}
	
//	public boolean emailUpdate(String id, String email) // 정보 수정
//	{
//		User user = em.find(User.class, id);
//		EntityTransaction transaction = em.getTransaction();
//		transaction.begin();
//		user.setEmail(email);		
//		transaction.commit();
//		return true;
//	}
//	
//	public boolean addressUpdate(String id, String address) // 정보 수정
//	{
//		User user = em.find(User.class, id);
//		EntityTransaction transaction = em.getTransaction();
//		transaction.begin();
//		user.setAddress(address);		
//		transaction.commit();
//		return true;
//	}
//	
//	public boolean phoneUpdate(String id, String phoneNumber) // 정보 수정
//	{
//		User user = em.find(User.class, id);
//		EntityTransaction transaction = em.getTransaction();
//		transaction.begin();
//		user.setPhoneNumber(phoneNumber);		
//		transaction.commit();
//		return true;
//	}
}
