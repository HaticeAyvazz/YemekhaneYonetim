package edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Repository.ımpl;

import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Repository.IRezervasyonRepository;
import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.entity.Rezervasyon;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
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
    public Rezervasyon save(Rezervasyon rezervasyon) {
        return entityManager.merge(rezervasyon);
    }

    @Override
    public void deleteById(int id) {
        Rezervasyon rezervasyon = entityManager.find(Rezervasyon.class, id);
        if (rezervasyon != null) {
            entityManager.remove(rezervasyon);
        }
    }
}
