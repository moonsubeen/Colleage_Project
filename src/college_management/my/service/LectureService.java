package college_management.my.service;

import java.util.List;

import college_management.my.db.LectureAttendanceDB;
import college_management.my.db.LectureDB;
import college_management.my.db.LectureHistoryDB;
import college_management.my.db.model.Lecture;
import college_management.my.db.model.LectureAttendance;
import college_management.my.db.model.LectureHistory;
import college_management.my.db.model.User;

public class LectureService {
	private static LectureService instance;
	protected static LectureDB db = LectureDB.getInstance();
	protected static LectureHistoryDB hdb = LectureHistoryDB.getInstance();
	protected static LectureAttendanceDB adb = LectureAttendanceDB.getInstance();
	
	public static LectureService getInstance() {
		if (instance == null) {
			instance = new LectureService();
		}
		return instance;
	}
	
	public boolean register(String id, String code, String name, int year, int semester, String day,
			String time, int count, int point, String plan) {
		db.register(id, code, name, year, semester, day, time, count, point, plan);
		return true;
	}
	
	public boolean register(String code, String id) {
		hdb.register(code, id, 0, "", "", "");
		return true;
	}
	
	public boolean register3(String id, String code, String month, String day, String attendance) {
		LectureAttendance attendances = adb.register(id, code, month, day, attendance);
		if(attendances == null)
			return false;
		return true;
	}
	
	public boolean update(String code, String name, int year, int semester, String day, String time, int max_count, int point, String plan) {
		db.update(code, name, year, semester, day, time, max_count, point, plan);
		return true;
	}
	
	public boolean grade(String code, String id, int grade) {
		String ranks;
		if(grade >= 95)
			ranks = "A+";
		else if(grade >= 90)
			ranks = "A";
		else if(grade >= 85)
			ranks = "B+";
		else if(grade >= 80)
			ranks = "B";
		else if(grade >= 75)
			ranks = "C+";
		else if(grade >= 70)
			ranks = "C";
		else if(grade >= 65)
			ranks = "D+";
		else if(grade >= 60)
			ranks = "D";
		else
			ranks = "F";
		hdb.grade(code, id, grade, ranks);
		return true;
	}
	
	public boolean problem(String code, String id, String problem) {
		hdb.problem(code, id, problem);
		return true;
	}
	
	public boolean evaluation(String code, String id, String evaluation) {
		hdb.evaluation(code, id, evaluation);
		return true;
	}
	
	public List<LectureAttendance> check(String id, String code) {
		return adb.check(id, code);
	}
	
	public Lecture read(String code) {
		return db.read(code);
	}
	
	public List<LectureHistory> hread(String id) {
		return hdb.read(id);
	}
	
	public List<Lecture> readAll() {
		return db.readAll();
	}
	
	public List<Lecture> readAll(String id) {
		return db.readAll(id);
	}
	
	public List<LectureAttendance> readAll2(String id) {
		return adb.readAll(id);
	}
	
	public List<LectureHistory> readAll3() {
		return hdb.readAll();
	}
	
	public List<LectureAttendance> readAll4() {
		return adb.readAll2();
	}
}