package com.example.yemekhaneyonetimsistemi.Repository.ımpl;

import com.example.yemekhaneyonetimsistemi.Repository.IBolumRepository;
import com.example.yemekhaneyonetimsistemi.entity.Admin;
import com.example.yemekhaneyonetimsistemi.entity.Bolum;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class BolumRepository implements IBolumRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Bolum> getAll() {
        return entityManager.createQuery("from Bolum",Bolum.class).getResultList();
    }

    @Override
    @Transactional
    public Bolum save(Bolum bolum) {
        return entityManager.merge(bolum);
    }

    @Override
    public void deleteById(int id) {
        findById(id).ifPresent(bolum->{
            entityManager.remove(bolum);
        });
    }

    @Override
    public Optional<Bolum> findById(int id) {
        Bolum bolum = entityManager.find(Bolum.class,id);
        return Optional.ofNullable(bolum);
    }
}
