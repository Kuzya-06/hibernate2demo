package ru.kuznetsov.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import ru.kuznetsov.entity.FilmEntity;

import java.util.List;

public class FilmDAO extends AbstractDao<FilmEntity> {
    public FilmDAO(SessionFactory sessionFactory) {
        super(FilmEntity.class, sessionFactory);
    }

    public FilmEntity getFilmIsAvailableForRent() {
        String sql = "SELECT f FROM FilmEntity f WHERE f.filmId NOT IN (SELECT DISTINCT film.filmId FROM InventoryEntity)";
        Query<FilmEntity> query = getCurrentSession().createQuery(sql, FilmEntity.class);
        query.setMaxResults(1);
        return query.getSingleResult();
    }

    // найти фильм(сущность) по названию фильма (Title)
    public FilmEntity getByName(String title) {
        String sql = "SELECT f FROM FilmEntity f WHERE f.title=:TITLE";
        Query<FilmEntity> query = getCurrentSession().createQuery(sql, FilmEntity.class);
        query.setParameter("TITLE", title);
        query.setMaxResults(1);
        return query.getSingleResult();
    }

    // найти ID фильма по названию фильма (Title)
    public Short getIDByName(String title) {
        String sql = "SELECT f FROM FilmEntity f WHERE f.title=:TITLE";
        Query<FilmEntity> query = getCurrentSession().createQuery(sql, FilmEntity.class);
        query.setParameter("TITLE", title);
        query.setMaxResults(1);
        return query.getSingleResult().getFilmId();
    }

    // найти фильмы в которых снимался актёр с таким ID
      public List<FilmEntity> getFilmsByActorId(Short id) {
        String sql = "SELECT f.*  FROM film f JOIN film_actor fa on f.film_id = fa.film_id JOIN actor a on a.actor_id = fa.actor_id WHERE a.actor_id=:ID";
        NativeQuery<FilmEntity> query = getCurrentSession().createNativeQuery(sql, FilmEntity.class);
        query.setParameter("ID", id);
        return query.list();
    }
}
