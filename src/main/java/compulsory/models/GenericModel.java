package compulsory.models;

import lombok.Data;

import javax.persistence.Column;

/**
 * a helpful class for abstract methods from GenericDao interface
 */
@Data
public abstract class GenericModel {
    @Column(name = "ID", length = 10, nullable = false, unique = false)
    Long id;

    /**
     * constructor
     *
     * @param id movie/genre id
     */
    GenericModel(Long id) {
        this.id = id;
    }
}
