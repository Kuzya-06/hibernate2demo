package ru.kuznetsov.dao;

import org.hibernate.SessionFactory;
import ru.kuznetsov.entity.CategoryEntity;

public class CategoryDAO extends AbstractDao<CategoryEntity>{
    public CategoryDAO( SessionFactory sessionFactory) {
        super(CategoryEntity.class, sessionFactory);
    }
}
