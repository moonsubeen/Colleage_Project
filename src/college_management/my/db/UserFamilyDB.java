package college_management.my.db;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

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
	
	public List<UserFamily> readAll() {
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
