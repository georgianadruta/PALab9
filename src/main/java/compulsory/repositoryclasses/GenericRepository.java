package compulsory.repositoryclasses;

import compulsory.models.GenericModel;

public interface GenericRepository {

    void create(GenericModel object);

    GenericModel findById(Long id);

    GenericModel findByName(String name);
}
