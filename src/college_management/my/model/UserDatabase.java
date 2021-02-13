package college_management.my.model;

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

import college_management.my.api.Permission;

public class UserDatabase {
	private static final String PERSISTENCE_UNIT_NAME = "h2";
	private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	protected static final EntityManager em = factory.createEntityManager();

	private static UserDatabase instance;
	
	public static UserDatabase getInstance() {
		if(instance == null) {
			instance = new UserDatabase();
		}
		return instance;
	}
	
	public boolean register(String id, String name, String email, String nationality, String phoneNumber, String address, String residentNumber, String birthdate, String sex, Permission role) {
		try {
			User user = new User();
			user.setId(id);
			user.setName(name);
			user.getPwd();
			user.setEmail(email);
			user.setNationality(nationality);
			user.setPhoneNumber(phoneNumber);
			user.setAddress(address);
			user.setResidentNumber(residentNumber);
			user.setBirthdate(birthdate);
			user.setSex(sex);
			user.setRole(role);

			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.persist(user);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public User login(String id, String pwd) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		
		CriteriaQuery<User> cQuery = criteriaBuilder.createQuery(User.class);
		Root<User> from = cQuery.from(User.class);
		Predicate where1 = criteriaBuilder.equal(from.get("id"), id);
		Predicate where2 = criteriaBuilder.equal(from.get("pwd"), pwd);
		Predicate whereFinal = criteriaBuilder.and(where1, where2);
		cQuery.where(whereFinal);
		
		Query query = em.createQuery(cQuery);
		List<User> resultList = query.getResultList();

		if (resultList.size() == 1) {
			return resultList.get(0);
		}
		else
			return null;
	}
	
	public boolean pwdupdate(String id, String pwd) {
		try {
			User user = em.find(User.class, id);
			if(pwd.length() < 8) {
				System.out.println("It must be at least 8 digits");
				return false;
			}
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			user.setPwd(pwd);
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean addressUpdate(String id, String address) {
		try {
			User user = em.find(User.class, id);

			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			user.setAddress(address);
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean emailUpdate(String id, String email) {
		try {
			User user = em.find(User.class, id);

			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			user.setEmail(email);
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean phoneUpdate(String id, String phoneNumber) {
		try {
			User user = em.find(User.class, id);

			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			user.setPhoneNumber(phoneNumber);
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public User read(String id) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		
		CriteriaQuery<User> cQuery = criteriaBuilder.createQuery(User.class);
		Root<User> from = cQuery.from(User.class);
		Predicate where = criteriaBuilder.equal(from.get("id"), id);
		cQuery.where(where);
		
		Query query = em.createQuery(cQuery);
		List<User> resultList = query.getResultList();

		if (resultList.size() == 1)
			return resultList.get(0);
		else
			return null;
	}
	
	public List<User> readAll() {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		
		CriteriaQuery<User> cQuery = criteriaBuilder.createQuery(User.class);
		cQuery.from(User.class);
		
		Query query = em.createQuery(cQuery);
		List<User> resultList = query.getResultList();

		if (resultList.size() > 0)
			return resultList;
		else
			return null;
	}
}
