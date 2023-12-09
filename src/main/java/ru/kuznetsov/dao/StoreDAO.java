package ru.kuznetsov.dao;

import org.hibernate.SessionFactory;
import ru.kuznetsov.entity.StoreEntity;

public class StoreDAO extends AbstractDao<StoreEntity> {
    public StoreDAO(SessionFactory sessionFactory) {
        super(StoreEntity.class, sessionFactory);
    }
}
