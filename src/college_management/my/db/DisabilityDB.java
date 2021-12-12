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

import college_management.my.db.model.QUserDisability;
import college_management.my.db.model.QUserFamily;
import college_management.my.db.model.Student;
import college_management.my.db.model.UserDisability;
import college_management.my.db.model.UserFamily;
import college_management.my.db.model.UserSoldier;
import college_management.my.db.model.User;

public class DisabilityDB extends BaseDB{
	private static DisabilityDB instance;
	
	public static DisabilityDB getInstance() {
		if(instance == null) {
			instance = new DisabilityDB();
		}
		return instance;
	}
	
	public UserDisability register(String id, String state, String disability, String document) {
		try {
			UserDisability disabilities = new UserDisability();
			User user = em.find(User.class, id);
			disabilities.setUser(user);
			disabilities.setState(state);
			disabilities.setDisability(disability);
			disabilities.setDocument(document);

			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.persist(disabilities);
			transaction.commit();
			
			return disabilities;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
		
	public UserDisability read(String id) {
		QUserDisability userdisability = QUserDisability.userDisability;
		UserDisability result = new JPAQuery<UserDisability>(em).from(userdisability).where(userdisability.user.id.eq(id)).fetchOne();
		return result;
	}
}
