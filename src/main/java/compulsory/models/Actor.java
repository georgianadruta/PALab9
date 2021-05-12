package compulsory.models;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

/**
 * helpful class to store movie actors in database
 */
@Getter
@Entity
@Table(name = "actors")
//@NamedQueries({
//        @NamedQuery(name = "Actor.findById", query = "SELECT obj FROM Actor AS obj WHERE obj.id=:id"),
//        @NamedQuery(name = "Actor.findByName", query = "SELECT obj FROM Actor AS obj WHERE obj.name=:name")
//})
public class Actor extends GenericModel {

    @Column(name = "name", length = 10, nullable = false, unique = true)
    String name;

    public Actor() {
        super(Long.valueOf(String.valueOf(UUID.randomUUID())));
        name = null;
    }

    public Actor(String name) {
        super(Long.valueOf(String.valueOf(UUID.randomUUID())));
        this.name = name;
    }

    @Id
    public Long getId() {
        return id;
    }
}
