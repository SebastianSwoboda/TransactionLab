package ch.bbc.uk223.transactions.TransactionLab;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;

import ch.bbc.uk223.transactions.util.JpaUtil;

public class EntityManagerTest {
	
    protected EntityManager em;

    @Before
    public void before() throws Exception {
        em = JpaUtil.createEntityManager();
    }
    
    @After
    public void after() throws Exception {
        em.close();
    }
    
}
