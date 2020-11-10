package ch.bbc.uk223.transactions.service;

import ch.bbc.uk223.transactions.data.Inventar;
import ch.bbc.uk223.transactions.data.Person;
import ch.bbc.uk223.transactions.error.RemovePersonException;
import ch.bbc.uk223.transactions.error.SavePersonException;
import ch.bbc.uk223.transactions.util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class PersonService extends JpaUtil {
    EntityManager em = createEntityManager();

    /**
     * Fügt eine Person aus der Datenbank und inkrementiert die Anzahl der
     * Personendatensätze in der Tabelle Inventar
     *
     * @param person Person die gespeichert werden soll
     * @throws RemovePersonException Falls eine Person nicht gespeichert werden kann
     */
    public void savePerson(Person person) throws SavePersonException {
        try {
            em.getTransaction().begin();
            em.persist(person);
            Inventar inventar = em.find(Inventar.class, 1);
            int count = inventar.getAnzahl();
            inventar.setAnzahl(count + 1);
            em.merge(inventar);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new SavePersonException("Person could not be saved");
        }
    }

    /**
     * Löscht eine Person aus der Datenbank und dekrementiert die Anzahl der
     * Personendatensätze in der Tabelle Inventar
     *
     * @param person Person die gelöscht werden soll
     * @throws RemovePersonException Falls eine Person nicht gelöscht werden kann
     */
    public void removePerson(Person person) throws RemovePersonException {
        try {
            em.getTransaction().begin();
            em.remove(person);
            Inventar inventar = em.find(Inventar.class, 1);
            int count = inventar.getAnzahl();
            inventar.setAnzahl(count - 1);
            em.merge(inventar);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RemovePersonException("Person could not be removed");
        }

    }

}
