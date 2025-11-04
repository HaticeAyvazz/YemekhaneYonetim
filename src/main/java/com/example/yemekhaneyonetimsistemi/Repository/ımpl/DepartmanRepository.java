package com.example.yemekhaneyonetimsistemi.Repository.ımpl;

import com.example.yemekhaneyonetimsistemi.Repository.IDepartmanRepository;
import com.example.yemekhaneyonetimsistemi.entity.Admin;
import com.example.yemekhaneyonetimsistemi.entity.Departman;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DepartmanRepository implements IDepartmanRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Departman> getAll() {
        return entityManager.createQuery("from Departman",Departman.class).getResultList();
    }

    @Override
    @Transactional
    public Departman save(Departman departman) {
        return entityManager.merge(departman);
    }

    @Override
    public void deleteById(int id) {
        findById(id).ifPresent(departman -> {
            entityManager.remove(departman);
        });
    }

    @Override
    public Optional<Departman> findById(int id) {
        Departman departman = entityManager.find(Departman.class,id);
        return Optional.ofNullable(departman);
    }
}
