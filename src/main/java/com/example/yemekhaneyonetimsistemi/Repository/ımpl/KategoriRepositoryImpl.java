package com.example.yemekhaneyonetimsistemi.Repository.ımpl;

import com.example.yemekhaneyonetimsistemi.Repository.IKategoriRepository;
import com.example.yemekhaneyonetimsistemi.entity.Kategori;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class KategoriRepositoryImpl implements IKategoriRepository {

    @PersistenceContext
    EntityManager entityManager;




    @Override
    public List<Kategori> getAll() {
        TypedQuery<Kategori>query=entityManager.createQuery("select k from Kategori k",Kategori.class);
        return query.getResultList();
    }


    @Override
    @Transactional
    public Kategori save(Kategori kategori) {
        return entityManager.merge(kategori);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
      findById(id).ifPresent(kategori->entityManager.remove(kategori));
    }


    @Override
    public Optional<Kategori> findById(Integer id) {
        Kategori kategori=entityManager.find(Kategori.class,id);
        return Optional.ofNullable(kategori);
    }

}
