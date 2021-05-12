package compulsory.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

/**
 * helpful class to store movie directors in database
 */
@Entity
@Table(name = "directors")
public class Directors extends GenericModel {
    @Column(name = "name", length = 10, nullable = false, unique = true)
    private String name;

    public Directors() {
        super(Long.valueOf(String.valueOf(UUID.randomUUID())));
        this.name = null;
    }

    public Directors(String name) {
        super(Long.valueOf(String.valueOf(UUID.randomUUID())));
        this.name = name;
    }

    @Id
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
