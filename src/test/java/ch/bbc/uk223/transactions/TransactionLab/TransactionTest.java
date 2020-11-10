package ch.bbc.uk223.transactions.TransactionLab;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ch.bbc.uk223.transactions.data.Inventar;
import ch.bbc.uk223.transactions.data.Person;
import ch.bbc.uk223.transactions.error.RemovePersonException;
import ch.bbc.uk223.transactions.error.SavePersonException;
import ch.bbc.uk223.transactions.service.PersonService;

public class TransactionTest extends EntityManagerTest
{

	private PersonService service = new PersonService();

	@Test
    public void saveTest() throws SavePersonException
    {
        Person gavin = new Person("King", "Gavin");
        
        service.savePerson(gavin);
        
        // Wirft ein Fehler wenn nicht genau ein Resultat zurück kommt
        em.createQuery("from Person p where p.name = 'King'", Person.class).getSingleResult();
        
        Inventar inventar = em.createQuery("from Inventar i where i.name = 'Person'", Inventar.class).getSingleResult();
        
        Assert.assertEquals(new Integer("1"), inventar.getAnzahl());
        
        Person dennis = new Person("Ritchie", "Dennis");
        
        service.savePerson(dennis);
        
        em.refresh(inventar);
        
        Assert.assertEquals(new Integer("2"), inventar.getAnzahl());
        
    }
	
	@Test
    public void removeTest() throws SavePersonException, RemovePersonException
    {
        Person linus = new Person("Torvalds", "Linus");
        
        Inventar expected = em.createQuery("from Inventar i where i.name = 'Person'", Inventar.class).getSingleResult();
        
        service.savePerson(linus);
        service.removePerson(linus);
        
        List<Person> persons = em.createQuery("from Person p where p.name = 'Torvalds'", Person.class).getResultList();
        
        assertTrue(persons.isEmpty());
        
        Inventar actual = em.createQuery("from Inventar i where i.name = 'Person'", Inventar.class).getSingleResult();
        Assert.assertEquals(expected, actual);
        
    }
	

	@Test(expected = SavePersonException.class)
    public void saveIllegalPerson() throws SavePersonException
    {
        Person doe = new Person();
        
        Inventar expected = em.createQuery("from Inventar i where i.name = 'Person'", Inventar.class).getSingleResult();
        
        service.savePerson(doe);
        
        Inventar actual = em.createQuery("from Inventar i where i.name = 'Person'", Inventar.class).getSingleResult();
        Assert.assertEquals(expected, actual);

    }
	


}