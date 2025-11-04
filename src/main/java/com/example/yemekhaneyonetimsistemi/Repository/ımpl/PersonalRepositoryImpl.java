package com.example.yemekhaneyonetimsistemi.Repository.ımpl;

import com.example.yemekhaneyonetimsistemi.Repository.IPersonalRepository;
import com.example.yemekhaneyonetimsistemi.entity.Personel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jdk.jfr.TransitionTo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PersonalRepositoryImpl implements IPersonalRepository {

    @PersistenceContext
    private EntityManager entityManager;



    @Override
    public List<Personel> getAll() {
        TypedQuery<Personel>query = entityManager.createQuery("Select p from Personel p", Personel.class);
        return query.getResultList();
    }


    @Override
    @Transactional
    public Personel save(Personel personel) {
        return entityManager.merge(personel);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
         findById(id).ifPresent(personel ->  entityManager.remove(personel));
    }


    @Override
    public Optional<Personel> findById(Integer id) {
       Personel personel = entityManager.find(Personel.class, id);
       return Optional.ofNullable(personel);
    }
}
