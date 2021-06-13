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
	
//	public List<UserFamily> readAll(String id) {
//		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
//		
//		CriteriaQuery<UserFamily> cQuery = criteriaBuilder.createQuery(UserFamily.class);
//		Root<UserFamily> from = cQuery.from(UserFamily.class);
//		Join<UserFamily, User> join = from.join("user");
//		Predicate where = criteriaBuilder.equal(join.get("id"), id);
//		cQuery.where(where);
//		
//		Query query = em.createQuery(cQuery);
//		List<UserFamily> resultList = query.getResultList();
//
//		if (resultList.size() > 0)
//			return resultList;
//		else
//			return null;
//	}
	
	public List<UserFamily> readAll(String id) {
		QUserFamily userfamily = QUserFamily.userFamily;
		List<UserFamily> result = new JPAQuery<UserFamily>(em).from(userfamily).where(userfamily.user.id.eq(id)).fetch();
		return result;
	}

}
