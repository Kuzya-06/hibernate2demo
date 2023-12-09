package ru.kuznetsov.dao;

import org.hibernate.SessionFactory;
import ru.kuznetsov.entity.PaymentEntity;

public class PaymentDAO extends AbstractDao<PaymentEntity> {
    public PaymentDAO( SessionFactory sessionFactory) {
        super(PaymentEntity.class, sessionFactory);
    }
}
