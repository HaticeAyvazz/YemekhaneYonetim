package edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Repository.ımpl;

import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Repository.IDepartmanRepository;
import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.entity.Departman;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
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
