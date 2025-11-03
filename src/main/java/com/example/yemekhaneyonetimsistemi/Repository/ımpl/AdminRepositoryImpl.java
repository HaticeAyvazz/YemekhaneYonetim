package com.example.yemekhaneyonetimsistemi.Repository.ımpl;

import com.example.yemekhaneyonetimsistemi.Repository.IAdminRepository;
import com.example.yemekhaneyonetimsistemi.entity.Admin;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class AdminRepositoryImpl implements IAdminRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Admin> findById(int id) {
        Admin admin = entityManager.find(Admin.class, id);
        return Optional.ofNullable(admin);
    }

    @Override
    public List<Admin> getAll() {
        return entityManager.createQuery("SELECT a FROM Admin a", Admin.class)
                .getResultList();
    }

    @Override
    @Transactional
    public Admin save(Admin admin) {
        return entityManager.merge(admin);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        findById(id).ifPresent(admin -> {
            entityManager.remove(admin);
        });


    }
}
