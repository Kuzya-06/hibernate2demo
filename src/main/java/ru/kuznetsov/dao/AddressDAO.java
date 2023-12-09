package ru.kuznetsov.dao;

import org.hibernate.SessionFactory;
import ru.kuznetsov.entity.AddressEntity;

public class AddressDAO extends AbstractDao<AddressEntity> {
    public AddressDAO(SessionFactory sessionFactory) {
        super(AddressEntity.class, sessionFactory);
    }
}
