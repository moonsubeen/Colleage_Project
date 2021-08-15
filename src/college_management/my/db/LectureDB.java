package college_management.my.db;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAUpdateClause;

import college_management.my.db.model.Lecture;
import college_management.my.db.model.LectureHistory;
import college_management.my.db.model.Professor;
import college_management.my.db.model.QLecture;
import college_management.my.db.model.QLectureHistory;
import college_management.my.db.model.Student;
import college_management.my.db.model.User;
import college_management.my.db.model.UserFamily;

public class LectureDB extends BaseDB{
	private static LectureDB instance;
	
	public static LectureDB getInstance() {
		if (instance == null) {
			instance = new LectureDB();
		}
		return instance;
	}
	
	public static void register(String id, String code, String name, int year, int semester, String day, 
			String time, int max_count, int point, String plan) {
		
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.createNativeQuery("INSERT INTO lecture (id, code, lecure_name, year, semester, day, time, max_count, point, lecture_plan) VALUES (?,?,?,?,?,?,?,?,?,?)")
			.setParameter(1, id).setParameter(2, code).setParameter(3, name).setParameter(4, year).setParameter(5, semester).setParameter(6, day).setParameter(7, time)
			.setParameter(8, max_count).setParameter(9, point).setParameter(10, plan).executeUpdate();
			transaction.commit();
	}
	
	public static void update(String code, String name, int year, int semester, String day, String time, int max_count, int point, String plan) {
		QLecture lecture = QLecture.lecture;
		em.getTransaction().begin();
		JPAUpdateClause update = new JPAUpdateClause(em, lecture);
		if(name != null) {
			update.set(lecture.name, name);
		} if(Integer.toString(year) != null) {
			update.set(lecture.year, year);
		} if(Integer.toString(semester) != null) {
			update.set(lecture.semester, semester);
		} if(day != null) {
			update.set(lecture.day, day);
		} if(time != null) {
			update.set(lecture.time, time);
		} if(Integer.toString(max_count) != null) {
			update.set(lecture.max_count, max_count);
		} if(Integer.toString(point) != null) {
			update.set(lecture.point, point);
		} if(plan != null) {
			update.set(lecture.lecturePlan, plan);
		}
		update.where(lecture.code.eq(code)).execute();
		em.getTransaction().commit();
		em.clear();
	}
	
	public static Lecture read(String code) {
		QLecture lecture = QLecture.lecture;
		
		Lecture result = new JPAQuery<Lecture>(em).from(lecture).where(lecture.code.eq(code)).fetchOne();
		return result;
	}
	
	public static List<Lecture> readAll() {
		QLecture lecture = QLecture.lecture;
		
		List<Lecture> result = new JPAQuery<Lecture>(em).from(lecture).fetch();
		return result;
	}
	
	public static List<Lecture> readAll(String id) {
		QLecture lecture = QLecture.lecture;
		
		List<Lecture> result = new JPAQuery<Lecture>(em).from(lecture).where(lecture.professor.user.id.eq(id)).fetch();
		return result;
	}
}
