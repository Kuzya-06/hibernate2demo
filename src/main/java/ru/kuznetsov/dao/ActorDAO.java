package ru.kuznetsov.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import ru.kuznetsov.entity.ActorEntity;
import java.util.List;

public class ActorDAO extends AbstractDao<ActorEntity> {
    public ActorDAO(SessionFactory sessionFactory) {
        super(ActorEntity.class, sessionFactory);

    }

    public List<ActorEntity> getActorsByFilms(String filmEntity) {
        if (filmEntity != null) {
            String sql = "SELECT * FROM actor a JOIN film_actor fa ON a.actor_id=fa.actor_id JOIN film f ON fa.film_id=f.film_id WHERE f.title =:NAME";
            NativeQuery<ActorEntity> nativeQuery = getCurrentSession().createNativeQuery(sql, ActorEntity.class);
            nativeQuery.setParameter("NAME", filmEntity);
            List<ActorEntity> actors = nativeQuery.list();
            return actors;
        }
        return null;
    }

    public List<ActorEntity> getActorsByIdFilms(short idFilm) {

        String sql = "SELECT * FROM actor a JOIN film_actor fa ON a.actor_id=fa.actor_id WHERE fa.film_id =:ID";
        NativeQuery<ActorEntity> nativeQuery = getCurrentSession().createNativeQuery(sql, ActorEntity.class);
        nativeQuery.setParameter("ID", idFilm);
        List<ActorEntity> list = nativeQuery.list();
        return list;
    }
}
