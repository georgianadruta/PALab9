package compulsory.repositoryclasses;

import compulsory.entitymanager.EntityManagerSingleton;
import compulsory.models.Directors;
import compulsory.models.GenericModel;

import javax.persistence.TypedQuery;

public class DirectorRepository implements GenericRepository {

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
        return em.find(Directors.class, id);
    }

    @Override
    public GenericModel findByName(String name) {
        var em = EntityManagerSingleton.INSTANCE.getEntityManager();
        TypedQuery<Directors> q = em.createQuery("SELECT obj FROM Directors obj WHERE obj.name = :name", Directors.class);
        q.setParameter("name", name);
        return q.getSingleResult();
    }
}
