package com.example.yemekhaneyonetimsistemi.Repository.ımpl;

import com.example.yemekhaneyonetimsistemi.Repository.IKullaniciRepository;
import com.example.yemekhaneyonetimsistemi.entity.Kullanici;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class KullaniciRepositoryImpl implements IKullaniciRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Kullanici save(Kullanici kullanici) {
        // ID 0 ise yeni kayıt (persist), değilse güncelleme (merge)
        if (kullanici.getKullaniciId() == 0) {
            entityManager.persist(kullanici);
            return kullanici;
        } else {
            return entityManager.merge(kullanici);
        }
    }


    // Login için Kullanıcı Bulma (TypedQuery Kullanımı)
    public Kullanici findByKullaniciAdi(String kullaniciAdi) {
        TypedQuery<Kullanici> query = entityManager.createQuery(
                "SELECT k FROM Kullanici k WHERE k.kullaniciAdi = :username",
                Kullanici.class
        );
        query.setParameter("username", kullaniciAdi);

        return query.getResultList().stream().findFirst().orElse(null);
    }
}