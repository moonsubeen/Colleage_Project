package college_management.my.service;

import college_management.my.db.LectureDB;

public class LectureService {
	private static LectureService instance;
	protected static LectureDB db = LectureDB.getInstance();
	
	public static LectureService getInstance() {
		if (instance == null) {
			instance = new LectureService();
		}
		return instance;
	}
}
