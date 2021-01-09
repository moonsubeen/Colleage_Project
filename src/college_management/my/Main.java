package college_management.my;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import college_management.my.model.User;

public class Main {
	private static final String PERSISTENCE_UNIT_NAME = "h2";
    private static EntityManagerFactory factory;

    @SuppressWarnings("unchecked")
	public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        
        // DB 인스턴스 생성
        EntityManager em = factory.createEntityManager();
        
        // 사용자 데이터 생성
        User[] userArr = new User[5];
        for(int i=0; i<userArr.length; i++) {
        	userArr[i] = new User();
        	userArr[i].setId(i + "");
        	userArr[i].getPwd();
        	userArr[i].setName("student-" + i);
        }
        
        // 트랜잭션 시작 & DB로 커밋
        EntityTransaction transaction = em.getTransaction(); // 트랜잭션은 작업단위
        transaction.begin(); 
        for(int i=0; i<userArr.length; i++) {
        	em.persist(userArr[i]);
        }
//        Query query_update = em.createQuery("update User t set t.pwd = :pwd" + " where t.id = 2");
//        query_update.setParameter("pwd", "123456asdf");  
//        int rowUpdate = query_update.executeUpdate();
//        System.out.println(rowUpdate);
//        User user = em.find(User.class, 2);
//        user.setPwd("123456");
        transaction.commit(); 
        
        // DB에서 사용자 읽기
        Query query = em.createQuery("select t from User t where t.id = 2");
        List<User> resultList = query.getResultList();
        
        for (User result : resultList) {
            System.out.println(result.toString());
        }
        System.out.println("Size: " + resultList.size());
        
        // DB 종료
        em.close();
    }
}
