package tima.global.entities;

import org.neo4j.ogm.annotation.*;

import java.util.Set;

@NodeEntity
public class User {

    private Long id;

    @Property(name = "id")
    private Long userId;

    @Relationship(type = "RATING")
    private Set<Movie> ratingMovies;

    @Relationship(type = "TAG")
    private Set<Movie> tagMovies;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Movie> getRatingMovies() {
        return ratingMovies;
    }

    public void setRatingMovies(Set<Movie> ratingMovies) {
        this.ratingMovies = ratingMovies;
    }

    public Set<Movie> getTagMovies() {
        return tagMovies;
    }

    public void setTagMovies(Set<Movie> tagMovies) {
        this.tagMovies = tagMovies;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userId=" + userId +
                ", ratingMovies=" + ratingMovies +
                ", tagMovies=" + tagMovies +
                '}';
    }
}
