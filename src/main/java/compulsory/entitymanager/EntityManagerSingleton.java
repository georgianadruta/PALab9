package compulsory.entitymanager;

import javax.persistence.*;
import java.util.Objects;


public enum EntityManagerSingleton {
    INSTANCE;

    @PersistenceContext
    private EntityManager em = null;
    @PersistenceUnit(name = "persistenceUnit")
    private EntityManagerFactory emf = null;

    /**
     * private constructor restricted to this class itself
     */
    void createEntityManager() {
        emf = Persistence.createEntityManagerFactory("persistenceUnit");
        em = emf.createEntityManager();
    }

    /**
     * method to get a connection
     *
     * @return a singleton connection
     */
    public EntityManager getEntityManager() {
        if (em == null)
            createEntityManager();
        return em;
    }

    public void closeEntityManager() {
        if (em != null)
            if (Objects.requireNonNull(em).isOpen()) {
                em.close();
            }
        em = null;

        if (emf != null)
            if (Objects.requireNonNull(emf).isOpen()) {
                emf.close();
            }
        emf = null;
    }
}
