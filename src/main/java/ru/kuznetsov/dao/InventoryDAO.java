package ru.kuznetsov.dao;

import org.hibernate.SessionFactory;
import ru.kuznetsov.entity.InventoryEntity;

public class InventoryDAO extends AbstractDao<InventoryEntity> {
    public InventoryDAO(SessionFactory sessionFactory) {
        super(InventoryEntity.class, sessionFactory);
    }
}
