package compulsory.repositoryclasses;

import compulsory.entitymanager.EntityManagerSingleton;
import compulsory.models.GenericModel;
import compulsory.models.Genre;

import javax.persistence.TypedQuery;

public class GenreRepository implements GenericRepository{
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
        return em.find(Genre.class, id);
    }

    @Override
    public GenericModel findByName(String name) {
        var em = EntityManagerSingleton.INSTANCE.getEntityManager();
        TypedQuery<Genre> q = em.createQuery("SELECT obj FROM Genre obj WHERE obj.name = :name", Genre.class);
        q.setParameter("name", name);
        return q.getSingleResult();
    }
}
