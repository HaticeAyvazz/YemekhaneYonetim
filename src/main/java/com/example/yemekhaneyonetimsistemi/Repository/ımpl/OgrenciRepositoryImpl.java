package com.example.yemekhaneyonetimsistemi.Repository.ımpl;

import com.example.yemekhaneyonetimsistemi.Repository.IOgrenciRepository;
import com.example.yemekhaneyonetimsistemi.entity.Ogrenci;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OgrenciRepositoryImpl implements IOgrenciRepository {

        private final EntityManager entityManager;

        public OgrenciRepositoryImpl(EntityManager entityManager) {
            this.entityManager = entityManager;
        }

    @Override
    public List<Ogrenci> getAll() {
        TypedQuery<Ogrenci> query = entityManager.createQuery("SELECT o FROM Ogrenci o", Ogrenci.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Ogrenci save(Ogrenci ogrenci) {
        return entityManager.merge(ogrenci);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Ogrenci ogr = entityManager.find(Ogrenci.class, id);
        if (ogr != null) {
            entityManager.remove(ogr);
        }
    }

    @Override
    public Optional<Ogrenci> findById(int id) {
        Ogrenci ogr = entityManager.find(Ogrenci.class, id);
        return Optional.ofNullable(ogr);
    }
}
