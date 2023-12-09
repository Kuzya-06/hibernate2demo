package ru.kuznetsov.dao;

import org.hibernate.SessionFactory;
import ru.kuznetsov.entity.FilmTextEntity;

public class FilmTextDAO extends AbstractDao<FilmTextEntity> {
    public FilmTextDAO( SessionFactory sessionFactory) {
        super(FilmTextEntity.class, sessionFactory);
    }
}
