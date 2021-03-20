package college_management.my.service;

import college_management.my.db.LectureDB;
import college_management.my.db.model.Lecture;

public class LectureService {
	private static LectureService instance;
	protected static LectureDB db = LectureDB.getInstance();
	
	public static LectureService getInstance() {
		if (instance == null) {
			instance = new LectureService();
		}
		return instance;
	}
	
	public boolean lregister(String id, String code, String name, int point, String plan) {
		Lecture lecture = db.lregister(id, code, name, point, plan);
		if(lecture == null)
			return false;
		return true;
	}
}
