package college_management.my.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAUpdateClause;

import college_management.my.api.config.Permission;
import college_management.my.db.model.UserFamily;
import college_management.my.db.model.QUser;
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
			QUser users = QUser.user;
//			SQLInsertClause insert = insert(users)
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
	
	public User login(String id, String pwd) {
		QUser user = QUser.user;
		User result = new JPAQuery<User>(em).from(user).where(user.id.eq(id).and(user.pwd.eq(pwd))).fetchOne();
		return result;
	}
	
	public static void update2(String id, String address, String name) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.createNativeQuery("update user m set m.address = :address where m.id = :id and m.name = :name")
		.setParameter("address", address).setParameter("id", id).setParameter("name", name).executeUpdate();
		transaction.commit();
	}
	
	public boolean update(String id, String pwd, String name, String email, String address, String phoneNumber) {
		try{
			QUser user = QUser.user;
			em.getTransaction().begin();
			JPAUpdateClause update = new JPAUpdateClause(em, user);
			
			if(pwd != null) {
//				if(pwd.length() < 8) {
//					System.out.println("It must be at least 8 digits");
//					return false;
//				}
				update.set(user.pwd, pwd);
			} if(name != null) {
				update.set(user.name, name);
			} if(email != null) {
				update.set(user.email, email);
			} if(address != null) {
				update.set(user.address, address);
			} if(phoneNumber != null) {
				update.set(user.phoneNumber, phoneNumber);
			}
			update.where(user.id.eq(id)).execute();
			em.getTransaction().commit();
//			em.refresh(user);
//			em.clear();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public User read(String id) {
		QUser user = QUser.user;
		User result = new JPAQuery<User>(em).from(user).where(user.id.eq(id)).fetchOne();
		return result;
	}
	
	public List<User> readAll() {
		QUser user = QUser.user;
		List<User> result = new JPAQuery<User>(em).from(user).fetch();
		return result;
	}
	public List<User> RolereadAll(Permission role){
		QUser user = QUser.user;
		List<User> result = new JPAQuery<User>(em).from(user).where(user.role.eq(role)).fetch();
		return result;
	}
}