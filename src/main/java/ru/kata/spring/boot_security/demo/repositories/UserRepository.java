package ru.kata.spring.boot_security.demo.repositories;
import ru.kata.spring.boot_security.demo.entities.User;
import java.util.List;

    public interface UserRepository{

    List<User> getAllUsers();

    User findByUsername(String username);

    User findByEmail(String username);

    User findUserById(Long id);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUserById(Long id);

}
