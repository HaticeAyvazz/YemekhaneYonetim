package edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Repository.ımpl;

import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Repository.IBolumRepository;
import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.entity.Bolum;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
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
