package compulsory.repositoryclasses;

import compulsory.entitymanager.EntityManagerSingleton;
import compulsory.models.GenericModel;
import compulsory.models.Movie;

import javax.persistence.TypedQuery;

public class MovieRepository implements GenericRepository {
    @Override
    public void create(GenericModel object) {
        var em = EntityManagerSingleton.INSTANCE.getEntityManager();
        if (object.getId() == null) {
            em.persist(object);
        }
    }

    @Override
    public GenericModel findById(Long id) {
        var em = EntityManagerSingleton.INSTANCE.getEntityManager();
        return em.find(Movie.class, id);
    }

    @Override
    public GenericModel findByName(String name) {
        var em = EntityManagerSingleton.INSTANCE.getEntityManager();
        TypedQuery<Movie> q = em.createQuery("SELECT obj FROM Movie obj WHERE obj.title = :name", Movie.class);
        q.setParameter("name", name);
        return q.getSingleResult();
    }
}
