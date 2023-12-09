package ru.kuznetsov.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.kuznetsov.MySessionFactory;
import ru.kuznetsov.dao.*;
import ru.kuznetsov.entity.*;

import java.math.BigDecimal;
import java.time.Year;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FilmService {
    SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
    private final ActorDAO actorDAO;
    private final CategoryDAO categoryDAO;
    private final FilmDAO filmDAO;
    private final FilmTextDAO filmTextDAO;
    private final LanguageDAO languageDAO;

    public FilmService() {
        actorDAO = new ActorDAO(sessionFactory);
        categoryDAO = new CategoryDAO(sessionFactory);
        filmDAO = new FilmDAO(sessionFactory);
        filmTextDAO = new FilmTextDAO(sessionFactory);
        languageDAO = new LanguageDAO(sessionFactory);
    }

    //  9. Добавить транзакционный метод, который описывает событие «сняли новый фильм, и он стал доступен для аренды».
    //  Фильм, язык, актеров, категории и т д выбери на свое усмотрение.
    public void newFilmShotAndAvailableForRent() {

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            LanguageEntity language = languageDAO.getItems(0, 6).stream().unordered().findAny().get();
            List<ActorEntity> actors = actorDAO.getItems(0, 10);
            List<CategoryEntity> categorys = categoryDAO.getItems(0, 3);

            FilmEntity film = new FilmEntity();
            film.setActors(new HashSet<>(actors));
            film.setCategories(new HashSet<>(categorys));
            film.setDescription("New Film JavaRush Project Hibernate(2)");
            film.setRating(Rating.PG13);
            film.setLength((short) 123);
            film.setLanguageId(language);
            film.setOriginalLanguageId(language);
            film.setSpecialFeatures(Set.of(Feature.BEHIND_THE_SCENES, Feature.COMMENTARIES));
            film.setTitle("Training");
            film.setRentalDuration((byte) 77);
            film.setRentalRate(BigDecimal.ONE);
            film.setReplacementCost(BigDecimal.TEN);
            film.setReleaseYear(Year.now());
            filmDAO.create(film);

            FilmTextEntity filmText = new FilmTextEntity();
            filmText.setDescription(film.getDescription());
            filmText.setTitle(film.getTitle());
            filmText.setFilm(film);
            filmText.setFilmId(film.getFilmId());
            filmTextDAO.create(filmText);

            session.getTransaction().commit();
        }
    }


    // -------------------------------------------------------------------------
    public FilmEntity getFilmByName(String title) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            FilmEntity byTitle = filmDAO.getByName(title);
            session.getTransaction().commit();
            return byTitle;
        }
    }

    // -------------------------------------------------------------------------
    public Short getIDByName(String title) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Short idByName = filmDAO.getIDByName(title);
            session.getTransaction().commit();
            return idByName;
        }
    }


    // --------get-----------------------------------------------------------------
    public FilmEntity getById(Short id) {
        try (Session session = sessionFactory.openSession()) {
            FilmEntity film = session.get(FilmEntity.class, id);
            return film;
        }
    }

    // --------getList-----------------------------------------------------------------
    public List<FilmEntity> getFilmsByActorId(Short id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            List<FilmEntity> filmByActorId = filmDAO.getFilmsByActorId(id);
            session.getTransaction().commit();
            return filmByActorId;
        }
    }

}