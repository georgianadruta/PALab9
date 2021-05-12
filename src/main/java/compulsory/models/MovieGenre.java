package compulsory.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "movies_genres")
public class MovieGenre extends GenericModel {
    @Column(name = "movieId", length = 10, nullable = false, unique = true)
    long movieID;
    @Column(name = "genreId", length = 10, nullable = false, unique = true)
    long genreID;

    public MovieGenre() {
        super(Long.valueOf(String.valueOf(UUID.randomUUID())));
        this.movieID = 0;
        this.genreID = 0;
    }

    public MovieGenre(int movieID, int genreID) {
        super(Long.valueOf(String.valueOf(UUID.randomUUID())));
        this.movieID = movieID;
        this.genreID = genreID;
    }


    @Id
    public Long getId() {
        return id;
    }
}
