package ru.kuznetsov.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.kuznetsov.MySessionFactory;
import ru.kuznetsov.dao.*;
import ru.kuznetsov.entity.ActorEntity;

import java.util.List;
import java.util.Locale;

public class ActorService {
    SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
    private final ActorDAO actorDAO;
    private final FilmDAO filmDAO;

    public ActorService() {
        actorDAO = new ActorDAO(sessionFactory);
        filmDAO = new FilmDAO(sessionFactory);

    }

    // Получить актёра по ID
    public ActorEntity getActorsById(Short id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(ActorEntity.class, id);
        }
    }

    // Получить актёров по названию фильма
    public List<ActorEntity> getActorsByFilms(String film) {
        String str = film.toUpperCase(Locale.ROOT);
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Short idByName = filmDAO.getIDByName(str);
            List<ActorEntity> actorsByFilms = actorDAO.getActorsByIdFilms(idByName);
            session.getTransaction().commit();
            return actorsByFilms;
        }
    }

    public List<ActorEntity> getActorsByFilms2(String film) {
        String str = film.toUpperCase(Locale.ROOT);
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            List<ActorEntity> actorsByFilms = actorDAO.getActorsByFilms(str);

            session.getTransaction().commit();
            return actorsByFilms;
        }
    }
}