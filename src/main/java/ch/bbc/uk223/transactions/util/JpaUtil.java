package ch.bbc.uk223.transactions.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	
    private static final EntityManagerFactory emf;

    static {
        try {
        	emf = Persistence.createEntityManagerFactory("transactionTest");
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static EntityManager createEntityManager(){
    	return emf.createEntityManager();
    }

}
