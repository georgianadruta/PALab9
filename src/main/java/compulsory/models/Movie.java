package compulsory.models;

import lombok.Getter;
import org.apache.log4j.Logger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;


/**
 * helpful class to create movie table
 */
@Getter
@Entity
@Table(name = "movies")
public class Movie extends GenericModel {
    private static final Logger logger = Logger.getLogger(Movie.class);

    @Column(name = "title", length = 10, nullable = false, unique = true)
    private final String title;
    @Column(name = "release_date", length = 10, nullable = false, unique = false)
    private final String releaseDate;
    @Column(name = "duration", length = 10, nullable = false, unique = false)
    private final int duration;
    @Column(name = "score", length = 10, nullable = false, unique = false)
    private final int score;

    public Movie() {
        super(Long.valueOf(String.valueOf(UUID.randomUUID())));
        title = null;
        releaseDate = null;
        duration = 0;
        score = 0;
    }

    /**
     * constructor
     *
     * @param title       movie title
     * @param releaseDate movie release, a string by the form "DD/MM/YYYY"
     * @param duration    movie duration in minutes
     * @param score       movie score, 0 < score <= 10
     */
    public Movie(String title, String releaseDate, int duration, int score) {
        super(Long.valueOf(String.valueOf(UUID.randomUUID())));
        this.title = title;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.score = score;

    }


    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
