package compulsory.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

/**
 * helpful class to create genre table
 */
@EqualsAndHashCode(callSuper = true)
@Getter
@Entity
@Table(name = "genres")
public class Genre extends GenericModel {
    @Column(name = "name", length = 10, nullable = false, unique = true)
    private final String name;

    public Genre() {
        super(Long.valueOf(String.valueOf(UUID.randomUUID())));
        name = null;
    }

    /**
     * constructor
     *
     * @param name genre name
     */
    public Genre(String name) {
        super(Long.valueOf(String.valueOf(UUID.randomUUID())));
        this.name = name;
    }


    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
