package uz.spring.book_project.service;

import uz.spring.book_project.entity.Book;

import java.util.List;
import java.util.Optional;

public class BookService extends BaseService<Book> {

    @Override
    public boolean create(Book book) {
        begin();
        entityManager.persist(book);
        commit();
        return true;
    }

    @Override
    protected boolean delete(int id) {
        begin();
        try {

            Book book = entityManager.find(Book.class, id);
            entityManager.remove(book);
            commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            rollback();
            return false;
        }

    }

    @Override
    protected boolean update(Book book) {
        return false;
    }

    @Override
    protected Optional<Book> get(int id) {
        begin();
        try {
            Book book = entityManager.find(Book.class, id);
            commit();
            return Optional.ofNullable(book);
        }catch (Exception e) {
            e.printStackTrace();
            rollback();
            return Optional.empty();
        }
    }

    @Override
    public  List<Book> getAll() {
        begin();
        List<Book> bookList = entityManager.createQuery("select b from Book b", Book.class).getResultList();
        commit();
        return bookList;
    }
}
