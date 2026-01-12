package edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Repository.ımpl;

import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Repository.IKategoriRepository;
import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.entity.Kategori;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
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
    public Kategori save(Kategori kategori) {
        return entityManager.merge(kategori);
    }

    @Override
    public void deleteById(Integer id) {
      findById(id).ifPresent(kategori->entityManager.remove(kategori));
    }


    @Override
    public Optional<Kategori> findById(Integer id) {
        Kategori kategori=entityManager.find(Kategori.class,id);
        return Optional.ofNullable(kategori);
    }

}
