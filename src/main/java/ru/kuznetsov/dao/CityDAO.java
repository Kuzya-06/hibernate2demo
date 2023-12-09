package ru.kuznetsov.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.kuznetsov.entity.CityEntity;

public class CityDAO extends AbstractDao<CityEntity> {
    public CityDAO(SessionFactory sessionFactory) {
        super(CityEntity.class, sessionFactory);
    }

    public CityEntity getByName(String city) {
        Query<CityEntity> query = getCurrentSession().createQuery("SELECT c FROM CityEntity c WHERE c.city = :NAME", CityEntity.class);
        query.setParameter("NAME", city);
        query.setMaxResults(1);
        return query.getSingleResult();
    }
}
