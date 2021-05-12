package compulsory.repositoryclasses;

import compulsory.entitymanager.EntityManagerSingleton;
import compulsory.models.Actor;
import compulsory.models.GenericModel;

import javax.persistence.TypedQuery;

public class ActorRepository implements GenericRepository {


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
        return em.find(Actor.class, id);
    }

    @Override
    public GenericModel findByName(String name) {
        var em = EntityManagerSingleton.INSTANCE.getEntityManager();
        TypedQuery<Actor> q = em.createQuery("SELECT obj FROM Actor obj WHERE obj.name = :name", Actor.class);
        q.setParameter("name", name);
        return q.getSingleResult();
    }
}
