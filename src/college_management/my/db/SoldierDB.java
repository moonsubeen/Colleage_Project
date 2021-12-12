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

import college_management.my.db.model.QUser;
import college_management.my.db.model.QUserSoldier;
import college_management.my.db.model.Student;
import college_management.my.db.model.UserSoldier;
import college_management.my.db.model.User;

public class SoldierDB extends BaseDB{
	private static SoldierDB instance;
	
	public static SoldierDB getInstance() {
		if(instance == null) {
			instance = new SoldierDB();
		}
		return instance;
	}
	
	public UserSoldier register(String id, String state, String militaryNumber, String type, 
			String classification, String branch, String ranks, String joinDate, String dischageDate) {
		try {
			UserSoldier soldier = new UserSoldier();
			User user = em.find(User.class, id);
			soldier.setUser(user);
			soldier.setState(state);
			soldier.setMilitaryNumber(militaryNumber);
			soldier.setType(type);
			soldier.setClassification(classification);
			soldier.setBranch(branch);
			soldier.setRank(ranks);
			soldier.setJoinDate(joinDate);
			soldier.setDischageDate(dischageDate);
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.persist(soldier);
			transaction.commit();
			
			return soldier;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public UserSoldier read(String id) {
		QUserSoldier soldier = QUserSoldier.userSoldier;
		UserSoldier result = new JPAQuery<UserSoldier>(em).from(soldier).where(soldier.user.id.eq(id)).fetchOne();
		return result;
	}
}
