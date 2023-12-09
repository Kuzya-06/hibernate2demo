package ru.kuznetsov.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.kuznetsov.entity.RentalEntity;

public class RentalDAO extends AbstractDao<RentalEntity> {
    public RentalDAO(SessionFactory sessionFactory) {
        super(RentalEntity.class, sessionFactory);
    }

    public RentalEntity getRentalWhereReturnDateIsNull() {
        String sql = "SELECT r from RentalEntity r WHERE r.returnDate IS NULL";
        Query<RentalEntity> query = getCurrentSession().createQuery(sql, RentalEntity.class);
        query.setMaxResults(1);

        return query.getSingleResult();
    }
}
