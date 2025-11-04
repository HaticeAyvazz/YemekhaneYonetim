package com.example.yemekhaneyonetimsistemi.Repository.ımpl;

import com.example.yemekhaneyonetimsistemi.Repository.IYemekRepository;
import com.example.yemekhaneyonetimsistemi.entity.Yemek;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class YemekRepositoryImpl implements IYemekRepository {

    @PersistenceContext
    private EntityManager entityManager;



    @Override
    public List<Yemek> getAll() {
        TypedQuery<Yemek>query=entityManager.createQuery("Select y from Yemek y",Yemek.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Yemek save(Yemek yemek) {
        return entityManager.merge(yemek);
    }


    @Override
    @Transactional
    public void deleteById(int id) {
    findById(id).ifPresent(entityManager::remove);
    }

    @Override
    public Optional<Yemek> findById(int id) {
        Yemek yemek=entityManager.find(Yemek.class,id);
        return Optional.ofNullable(yemek);
    }

}
