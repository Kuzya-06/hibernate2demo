package ru.kuznetsov;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.kuznetsov.entity.*;

public class MySessionFactory {
    private static MySessionFactory instance;
    private SessionFactory sessionFactory;

    private MySessionFactory() {

        sessionFactory = new Configuration()
                .addAnnotatedClass(ActorEntity.class)
                .addAnnotatedClass(AddressEntity.class)
                .addAnnotatedClass(CategoryEntity.class)
                .addAnnotatedClass(CityEntity.class)
                .addAnnotatedClass(CountryEntity.class)
                .addAnnotatedClass(CustomerEntity.class)
                .addAnnotatedClass(FilmEntity.class)
                .addAnnotatedClass(FilmTextEntity.class)
                .addAnnotatedClass(InventoryEntity.class)
                .addAnnotatedClass(LanguageEntity.class)
                .addAnnotatedClass(PaymentEntity.class)
                .addAnnotatedClass(RentalEntity.class)
                .addAnnotatedClass(StaffEntity.class)
                .addAnnotatedClass(StoreEntity.class)
                .buildSessionFactory();

    }

    public static SessionFactory getSessionFactory() {
        if (instance == null) {
            instance = new MySessionFactory();
        }
        return instance.sessionFactory;
    }
}
