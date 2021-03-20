package college_management.my.db;

import javax.persistence.EntityTransaction;

import college_management.my.db.model.StudentDisability;
import college_management.my.db.model.StudentSoldier;
import college_management.my.db.model.User;

public class InfoDB extends BaseDB{
	private static InfoDB instance;
	
	public static InfoDB getInstance() {
		if(instance == null) {
			instance = new InfoDB();
		}
		return instance;
	}
	
	public StudentDisability dregister(boolean state, String disability, String document) {
		try {
			StudentDisability disabilities = new StudentDisability();
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
	
	public StudentSoldier sdregister(boolean state, String soldiernumber, String militatySpecific, String militayspecifies,
			String militatySpeciality, String militaryServiceSite, String rank, String enlistDate, 
			String dischageDate, String militaryServiceDate) {
		try {
			StudentSoldier soldier = new StudentSoldier();
			soldier.setSoldierNumber(soldiernumber);
			soldier.setMilitatySpecific(militatySpecific);
			soldier.setMilitayspecifies(militayspecifies);
			soldier.setMilitatySpeciality(militatySpeciality);
			soldier.setMilitaryServiceSite(militaryServiceSite);
			soldier.setRank(rank);
			soldier.setEnlistDate(enlistDate);
			soldier.setDischageDate(dischageDate);
			soldier.setMilitaryServiceDate(militaryServiceDate);
			
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
}
