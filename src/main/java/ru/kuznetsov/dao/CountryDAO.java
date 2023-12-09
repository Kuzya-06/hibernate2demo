package ru.kuznetsov.dao;

import org.hibernate.SessionFactory;
import ru.kuznetsov.entity.CountryEntity;

public class CountryDAO extends AbstractDao<CountryEntity> {
    public CountryDAO( SessionFactory sessionFactory) {
        super(CountryEntity.class, sessionFactory);
    }
}
