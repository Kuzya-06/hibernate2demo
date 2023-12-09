package ru.kuznetsov;

import ru.kuznetsov.entity.ActorEntity;
import ru.kuznetsov.entity.FilmEntity;
import ru.kuznetsov.service.ActorService;
import ru.kuznetsov.service.FilmService;

import java.util.List;

public class MainSecondary {

    public static void main(String[] args) {

        FilmService filmService = new FilmService();


        System.out.println("*-".repeat(10));

        FilmEntity byName = filmService.getFilmByName("ALONE TRIP");
        System.out.println(byName);

        System.out.println("*-".repeat(10));

        System.out.println("-*-".repeat(10));

        Short iDByName = filmService.getIDByName("ALONE TRIP");
        System.out.println(iDByName);

        System.out.println("-*-".repeat(10));

        System.out.println("-**-".repeat(10));

        FilmEntity filmById = filmService.getById((short) 17);
        System.out.println("Film for ID=17 -> " + filmById);

        System.out.println("-**-".repeat(10));

        List<FilmEntity> filmsByActorId = filmService.getFilmsByActorId((short) 44);
        filmsByActorId.forEach(System.out::println);

// ---------------------------------------------------------------------------
        ActorService actorService = new ActorService();

        System.out.println("-++-".repeat(10));

        List<ActorEntity> actors = actorService.getActorsByFilms("ITALIAN AFRICAN");
        for (ActorEntity actor : actors) {
            System.out.println("Актёры: " + actor.getFirstName() + " " + actor.getLastName());
        }

        System.out.println("-++-".repeat(10));

        System.out.println("-00-".repeat(10));

        ActorEntity actorsById = actorService.getActorsById((short) 56);
        System.out.println(actorsById);

        System.out.println("-00-".repeat(10));

        List<ActorEntity> films2 = actorService.getActorsByFilms2("FRISCO FORREST");
        films2.forEach(System.out::println);
    }
}
