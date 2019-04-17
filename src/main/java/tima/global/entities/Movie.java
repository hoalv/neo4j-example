package tima.global.entities;

import org.neo4j.ogm.annotation.*;

import java.util.Set;

@NodeEntity
public class Movie {
    @Id @GeneratedValue
    private Long id;

    @Property(name = "id")
    private Long movieId;

    private String title;

    @Relationship(type = "GENRE")
    private Genre genre;

    @Relationship(type = "RATING", direction = "INCOMING")
    private Set<User> ratingUsers;

    @Relationship(type = "TAG", direction = "INCOMING")
    private Set<User> tagUsers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Set<User> getRatingUsers() {
        return ratingUsers;
    }

    public void setRatingUsers(Set<User> ratingUsers) {
        this.ratingUsers = ratingUsers;
    }

    public Set<User> getTagUsers() {
        return tagUsers;
    }

    public void setTagUsers(Set<User> tagUsers) {
        this.tagUsers = tagUsers;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", movieId=" + movieId +
                ", title='" + title + '\'' +
                ", genre=" + genre +
                '}';
    }
}
