package com.example.yemekhaneyonetimsistemi.Repository.ımpl;

import com.example.yemekhaneyonetimsistemi.Repository.IRezervasyonRepository;
import com.example.yemekhaneyonetimsistemi.entity.Rezervasyon;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RezervasyonRepositoryImpl implements IRezervasyonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Rezervasyon> findAll() {
        TypedQuery<Rezervasyon> query = entityManager.createQuery("SELECT r FROM Rezervasyon r", Rezervasyon.class);
        return query.getResultList();
    }

    @Override
    public Optional<Rezervasyon> findById(int id) {
        return Optional.ofNullable(entityManager.find(Rezervasyon.class, id));
    }

    @Override
    @Transactional
    public Rezervasyon save(Rezervasyon rezervasyon) {
        return entityManager.merge(rezervasyon);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Rezervasyon rezervasyon = entityManager.find(Rezervasyon.class, id);
        if (rezervasyon != null) {
            entityManager.remove(rezervasyon);
        }
    }
}
