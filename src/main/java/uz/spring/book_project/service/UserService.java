package uz.spring.book_project.service;

import uz.spring.book_project.entity.User;

import java.util.List;
import java.util.Optional;

public class UserService extends BaseService<User> {

    @Override
    public boolean create(User user) {
        Optional<User> optionalUser = findByEmail(user.getEmail());
        begin();
        if (optionalUser.isEmpty()) {
            entityManager.persist(user);
            commit();
            return true;
        }
        commit();
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public Optional<User> get(int id) {
        return Optional.empty();
    }

    @Override
    public List<User> getAll() {
        begin();
        List<User> users = entityManager.createQuery("select u from User u", User.class).getResultList();
        commit();
        return users;
    }

    public Optional<User> findByEmail(String email) {
        begin();
        try {
            User user = entityManager.createQuery("select u from User u where u.email ilike :email", User.class)
                    .setParameter("email", email)
                    .getSingleResult();
            commit();
            return Optional.ofNullable(user);
        }catch (Exception e) {
            e.printStackTrace();
            rollback();
            return Optional.empty();
        }
    }
}
