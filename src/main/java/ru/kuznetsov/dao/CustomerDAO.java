package ru.kuznetsov.dao;

import org.hibernate.SessionFactory;
import ru.kuznetsov.entity.CustomerEntity;

public class CustomerDAO extends AbstractDao<CustomerEntity> {
    public CustomerDAO( SessionFactory sessionFactory) {
        super(CustomerEntity.class, sessionFactory);
    }
}
