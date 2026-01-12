package edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Repository.ımpl;

import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Repository.IKullaniciRepository;
import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.entity.Kullanici;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
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
    public Kullanici save(Kullanici kullanici) {
        return entityManager.merge(kullanici);
    }

    @Override
    public void deleteById(int id) {
        Kullanici kullanici = entityManager.find(Kullanici.class, id);
        if (kullanici != null) {
            entityManager.remove(kullanici);
        }
    }

}
