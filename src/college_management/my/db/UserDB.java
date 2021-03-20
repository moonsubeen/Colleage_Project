package college_management.my.db;

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

import college_management.my.api.config.Permission;
import college_management.my.db.model.UserFamily;
import college_management.my.db.model.User;

public class UserDB extends BaseDB{
	private static UserDB instance;
	
	public static UserDB getInstance() {
		if(instance == null) {
			instance = new UserDB();
		}
		return instance;
	}
	
	public User register(String id, String name, String email, String nationality, String phoneNumber, String address, String residentNumber, String birthdate, String sex, Permission role) {
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
			
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public UserFamily fregister(String id, String relation, String name, String phonenumber) {
		try {
			User user = em.find(User.class, id);
			UserFamily family = new UserFamily();
			family.setUser(user);
			family.setName(name);
			family.setRelation(relation);
			family.setPhoneNumber(phonenumber);
			
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.persist(family);
			transaction.commit();
			
			return family;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
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
	
	public boolean update(String id, String pwd, String name, String email, String address, String phoneNumber) {
		try {
			User user = em.find(User.class, id);
			EntityTransaction transaction = em.getTransaction();
		
			if(pwd != null) {
				if(pwd.length() < 8) {
					System.out.println("It must be at least 8 digits");
					return false;
				}
				user.setPwd(pwd);
			}
			if(name != null)
				user.setName(name);
			if(email != null)
				user.setEmail(email);
			if(address != null)
				user.setAddress(address);
			if(phoneNumber != null)
				user.setPhoneNumber(phoneNumber);
			
			transaction.begin();
			em.persist(user);
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
	
	public List<UserFamily> freadAll() {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		
		CriteriaQuery<UserFamily> cQuery = criteriaBuilder.createQuery(UserFamily.class);
		cQuery.from(UserFamily.class);
		
		Query query = em.createQuery(cQuery);
		List<UserFamily> resultList = query.getResultList();

		if (resultList.size() > 0)
			return resultList;
		else
			return null;
	}
}