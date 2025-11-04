package com.example.yemekhaneyonetimsistemi.Repository.ımpl;

import com.example.yemekhaneyonetimsistemi.Repository.IFakulteRepository;
import com.example.yemekhaneyonetimsistemi.entity.Fakulte;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class FakulteRepositoryImpl implements IFakulteRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Fakulte> getAll() {
        return entityManager.createQuery("from Fakulte",Fakulte.class).getResultList();
    }

    @Override
    @Transactional
    public Fakulte save(Fakulte fakulte) {
        return entityManager.merge(fakulte);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        findById(id).ifPresent(fakulte->entityManager.remove(fakulte));
    }

    @Override
    @Transactional
    public Optional<Fakulte> findById(Integer id) {
        Fakulte fakulte = entityManager.find(Fakulte.class,id);
        return Optional.ofNullable(fakulte);
    }

}
