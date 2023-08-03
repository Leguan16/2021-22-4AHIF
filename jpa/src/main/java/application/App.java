package application;

import domain.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.util.List;

public class App {

    public static void main(String[] args) {
        var factory = Persistence.createEntityManagerFactory("at.htlstp.jpa.movies");
        var entityManager = factory.createEntityManager();
        var movie = new Movie(null, "Star Wars", null);
        var director = new Director("George Lucas");
        var actors = List.of(
                new Actor(null, "Johnny Depp", 57, List.of(movie)),
                new Actor(null, "Jason Statham", 53, List.of(movie))
        );
        director.addMovie(movie);
        //movie.setDirector(director);
        entityManager.getTransaction().begin();
        entityManager.persist(movie);
        entityManager.persist(director);
        actors.forEach(entityManager::persist);
        entityManager.getTransaction().commit();
        entityManager.clear();
        System.out.println(entityManager.createQuery("""
                        select new domain.Actor(actor.name, actor.age)
                        from Actor actor
                        """,
                Actor.class).getResultList());
    }

    private static void actorExample(EntityManager entityManager) {
        var actor = new Actor(null, "Johnny Depp", 57, null);

        entityManager.getTransaction().begin();
        entityManager.persist(actor);
        entityManager.getTransaction().commit();
        entityManager.clear();

        actor.setAge(58);
        entityManager.getTransaction().begin();
        entityManager.merge(actor);
        entityManager.getTransaction().commit();

        System.out.println(entityManager.find(Actor.class, 1));
        entityManager.close();
    }
}
