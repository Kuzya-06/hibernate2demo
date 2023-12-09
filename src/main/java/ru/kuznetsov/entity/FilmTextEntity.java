package ru.kuznetsov.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "film_text", schema = "movie")
public class FilmTextEntity {
    @Id
    @Column(name = "film_id")
    private Short filmId;

   @OneToOne
   @JoinColumn(name = "film_id")
   private FilmEntity film;

    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "description", columnDefinition = "text")
    private String description;

    public Short getFilmId() {
        return filmId;
    }

    public void setFilmId(Short filmId) {
        this.filmId = filmId;
    }

    public FilmEntity getFilm() {
        return film;
    }

    public void setFilm(FilmEntity film) {
        this.film = film;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmTextEntity that = (FilmTextEntity) o;
        return filmId == that.filmId && Objects.equals(title, that.title) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmId, title, description);
    }
}
