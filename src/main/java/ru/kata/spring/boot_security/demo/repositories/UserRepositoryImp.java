package ru.kata.spring.boot_security.demo.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepositoryImp implements UserRepository{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<User> getAllUsers() {
        return manager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User findByUsername(String username) {
        return (User) manager
                .createQuery("select u from User u left join fetch u.roles where u.username=:username")
                .setParameter("username", username)
                .getSingleResult();
    }



    @Override
    public User findByEmail(String email){
        return (User) manager
                .createQuery("select u from User u left join fetch u.roles where u.email=:email")
                .setParameter("email", email)
                .getSingleResult();
     }

    @Override
    public User findUserById(Long id) {
        return manager.find(User.class, id);
    }

    @Transactional
    @Override
    public void saveUser(User user) {
         manager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        manager.merge(user);
    }


    @Override
    public void deleteUserById(Long id) {
        manager.createQuery ("delete from User " + "where id=:id")
                .setParameter("id", id).executeUpdate();
    }


}
