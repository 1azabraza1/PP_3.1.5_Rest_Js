package ru.kata.spring.boot_security.demo.repositories;

import ru.kata.spring.boot_security.demo.entities.Role;

import java.util.List;
import java.util.Set;

public interface RoleRepository {
    List<Role> getAllRoles();

    Set<Role> findById(Set<Long> rolesId);

    void saveRole(Role role);

}
