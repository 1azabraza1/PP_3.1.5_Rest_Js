package ru.kata.spring.boot_security.demo.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.entities.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class RoleRepositoryImp implements RoleRepository{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Role> getAllRoles() {
        return manager.createQuery("from Role", Role.class).getResultList();
    }

    @Override
    public Set<Role> findById(Set<Long> rolesId){
        List<Role> roleList = manager.createQuery("select r from Role r where r.id in :rolesId", Role.class)
                .setParameter("rolesId", rolesId)
                .getResultList();
        return new HashSet<>(roleList);
    }

    @Transactional
    @Override
    public void saveRole(Role role) {
        manager.persist(role);
    }

}
