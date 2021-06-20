package college_management.my.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class BaseDB {
	private static final String PERSISTENCE_UNIT_NAME = "mysql";
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	protected static EntityManager em = factory.createEntityManager();
}
