package com.infoshare.test.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Director {
    @Id
    @GeneratedValue
    private Long Id;
    private String firstName;
    private String lastName;
    // @OneToMany(mappedBy = "director", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    // private List<Movie> movies;

    public Director() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

   /* public List<Movie> getMovies() {
        return movies;
    }*/

   /* public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Director director = (Director) o;
        return Objects.equals(firstName, director.firstName) &&
                Objects.equals(lastName, director.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "Director{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}