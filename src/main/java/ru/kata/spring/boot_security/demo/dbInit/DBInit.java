package ru.kata.spring.boot_security.demo.dbInit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.entities.Role;
import ru.kata.spring.boot_security.demo.entities.User;
import ru.kata.spring.boot_security.demo.repositories.UserRepository;
import ru.kata.spring.boot_security.demo.service.RoleServiceImp;

import javax.annotation.PostConstruct;
import java.util.Set;

@Component
public class DBInit {
    private final UserRepository userRepository;
    private final RoleServiceImp roleService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public DBInit(UserRepository userRepository, RoleServiceImp roleService, PasswordEncoder passwordEncoder) {
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void run() {

        Role userRole = new Role("ROLE_USER");
        roleService.saveRole(userRole);

        Role adminRole = new Role("ROLE_ADMIN");
        roleService.saveRole(adminRole);

        userRepository.saveUser(new User("admin", passwordEncoder.encode("1"), 22, "admin@mail.ru", Set.of(adminRole)));
        userRepository.saveUser(new User("user", passwordEncoder.encode("1"), 23, "user@mail.ru", Set.of(userRole)));

    }
}
