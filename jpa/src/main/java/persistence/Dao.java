package persistence;

import domain.Actor;
import domain.Movie;
import jakarta.persistence.*;

public class Dao {

    private static Dao dao;

    private Dao() {}

    public static Dao getInstance() {
        if (dao == null)
            dao = new Dao();
        return dao;
    }

    public <T> T save(EntityManager entityManager, T movie) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(movie);
            entityManager.getTransaction().commit();
            return movie;
        } catch (Exception exception) {
            entityManager.getTransaction().rollback();
            throw exception;
        }
    }
}
