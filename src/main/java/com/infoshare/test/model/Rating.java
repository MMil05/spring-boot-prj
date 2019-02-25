package com.infoshare.test.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Objects;

@Entity
public class Rating {

    @Id
    @GeneratedValue
    private Long Id;

    private int score;
    //   @OneToOne(mappedBy = "rating")
    //   private Movie movie;

    public Rating() {
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

//    public Movie getMovie() {
//        return movie;
//    }

//    public void setMovie(Movie movie) {
//        this.movie = movie;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating = (Rating) o;
        return score == rating.score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(score);
    }

    @Override
    public String toString() {
        return "Rating{" +
                "score=" + score +
                '}';
    }
}