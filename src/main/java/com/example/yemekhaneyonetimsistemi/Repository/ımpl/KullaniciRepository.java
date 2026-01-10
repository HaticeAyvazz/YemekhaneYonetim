package com.example.yemekhaneyonetimsistemi.Repository.ımpl;

import com.example.yemekhaneyonetimsistemi.Repository.IKullaniciRepository;
import com.example.yemekhaneyonetimsistemi.entity.Kullanici;
import com.example.yemekhaneyonetimsistemi.entity.Rezervasyon;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class KullaniciRepository implements IKullaniciRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Kullanici> getAll() {
        TypedQuery<Kullanici> query = entityManager.createQuery("SELECT r FROM Kullanici r", Kullanici.class);
        return query.getResultList();
    }

    @Override
    public Optional<Kullanici> findById(int id) {
        return Optional.ofNullable(entityManager.find(Kullanici.class, id));
    }

    @Override
    @Transactional
    public Kullanici save(Kullanici kullanici) {
        return entityManager.merge(kullanici);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Kullanici kullanici = entityManager.find(Kullanici.class, id);
        if (kullanici != null) {
            entityManager.remove(kullanici);
        }
    }

}
