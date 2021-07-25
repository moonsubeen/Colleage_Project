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
	
	public Lecture register(String id, String code, String name, String year, String semester, String day, 
			String time, String max_count, String point, String plan) {
		try {
			Lecture lecture = new Lecture();
			User user = em.find(User.class, id);
			Professor professor = new Professor();
			professor.setUser(user);
			lecture.setProfessor(professor);
			lecture.setCode(code);
			lecture.setName(name);
			lecture.setYear(year);
			lecture.setSemester(semester);
			lecture.setDay(day);
			lecture.setTime(time);
			lecture.setMax_count(max_count);
			lecture.setPoint(point);
			lecture.setLecturePlan(plan);
			
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.persist(lecture);
			transaction.commit();
			
			return lecture;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
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
