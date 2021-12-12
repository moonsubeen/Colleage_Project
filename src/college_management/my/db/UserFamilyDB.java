package college_management.my.db;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.querydsl.jpa.impl.JPAQuery;

import college_management.my.db.model.QUserFamily;
import college_management.my.db.model.Student;
import college_management.my.db.model.User;
import college_management.my.db.model.UserFamily;

public class UserFamilyDB extends BaseDB{
	private static UserFamilyDB instance;
	
	public static UserFamilyDB getInstance() {
		if (instance == null) {
			instance = new UserFamilyDB();
		}
		return instance;
	}
	
	public UserFamily register(String id, String relation, String name, String phonenumber) {
		try {
			UserFamily family = new UserFamily();
			User user = em.find(User.class, id);
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
	
	public List<UserFamily> readAll(String id) {
		QUserFamily userfamily = QUserFamily.userFamily;
		List<UserFamily> result = new JPAQuery<UserFamily>(em).from(userfamily).where(userfamily.user.id.eq(id)).fetch();
		return result;
	}
	
	public UserFamily read(String id) {
		QUserFamily userfamily = QUserFamily.userFamily;
		UserFamily result = new JPAQuery<UserFamily>(em).from(userfamily).where(userfamily.user.id.eq(id)).fetchOne();
		return result;
	}

}
