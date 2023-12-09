package ru.kuznetsov.dao;

import org.hibernate.SessionFactory;
import ru.kuznetsov.entity.LanguageEntity;

public class LanguageDAO extends AbstractDao<LanguageEntity> {
    public LanguageDAO( SessionFactory sessionFactory) {
        super(LanguageEntity.class, sessionFactory);
    }
}
