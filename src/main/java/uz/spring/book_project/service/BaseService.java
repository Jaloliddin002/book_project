package uz.spring.book_project.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Optional;

public abstract class BaseService<T> {

    protected static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("book_project");

    protected static final EntityManager entityManager = emf.createEntityManager();

    protected void begin() {
        entityManager.getTransaction().begin();
    }

    protected void rollback() {
        entityManager.getTransaction().rollback();
    }

    protected void commit() {
        entityManager.getTransaction().commit();
    }

   protected abstract boolean create (T t);
   protected abstract boolean delete (int id);
   protected abstract boolean update (T t);
   protected abstract Optional<T> get (int id);
   protected abstract List<T> getAll();
}
