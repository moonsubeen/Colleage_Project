package college_management.my.service;

import college_management.my.db.InfoDB;
import college_management.my.db.model.StudentDisability;
import college_management.my.db.model.StudentSoldier;

public class InfoService {
	private static InfoService instance;
	protected static InfoDB db = InfoDB.getInstance();

	public static InfoService getInstance() {
		if (instance == null) {
			instance = new InfoService();
		}
		return instance;
	}
	
	public boolean dregister(boolean state, String disability, String document) {
		if(state == false) {
			disability = null;
			document = null;
		}
		StudentDisability disabilities = db.dregister(state, disability, document);
		if(disabilities == null)
			return false;
		return true;
	}
	
	public boolean sdregister(boolean state, String soldiernumber, String militatySpecific, String militayspecifies,
			String militatySpeciality, String militaryServiceSite, String rank, String enlistDate, 
			String dischageDate, String militaryServiceDate) {
		if(state == false) {
			soldiernumber = null;
			militatySpecific = null;
			militayspecifies = null;
			militatySpeciality = null;
			militaryServiceSite = null;
			rank = null;
			enlistDate = null;
			dischageDate = null;
			militaryServiceDate = null;
		}
		
		StudentSoldier soldier = db.sdregister(state, soldiernumber, militatySpecific, militayspecifies, 
				militatySpeciality, militaryServiceSite, rank, enlistDate, dischageDate, 
				militaryServiceDate);
		if(soldier == null)
			return false;
		return true;
	}
}
