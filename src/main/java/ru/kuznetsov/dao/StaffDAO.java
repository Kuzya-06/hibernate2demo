package ru.kuznetsov.dao;

import org.hibernate.SessionFactory;
import ru.kuznetsov.entity.StaffEntity;

public class StaffDAO extends AbstractDao<StaffEntity>{
    public StaffDAO(SessionFactory sessionFactory) {
        super(StaffEntity.class, sessionFactory);
    }
}
