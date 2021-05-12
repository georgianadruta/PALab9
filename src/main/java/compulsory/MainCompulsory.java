package compulsory;

import compulsory.entitymanager.EntityManagerSingleton;
import compulsory.models.Actor;
import compulsory.models.Genre;
import compulsory.models.Movie;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;

public class MainCompulsory {
    static final Logger logger = Logger.getLogger(MainCompulsory.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();

        EntityManager em;
        try {
            em = EntityManagerSingleton.INSTANCE.getEntityManager();
            em.getTransaction().begin();

            Actor costel = new Actor("Costel");
            Movie titanic = new Movie("Titanic", "1980", 120, 9);
            Genre drama = new Genre("Drama");

            em.persist(costel);
            em.persist(titanic);
            em.persist(drama);

            em.getTransaction().commit();
            EntityManagerSingleton.INSTANCE.closeEntityManager();
        } catch (Exception exception) {
            System.err.println(exception);
        } finally {
            EntityManagerSingleton.INSTANCE.closeEntityManager();
        }
    }
}
