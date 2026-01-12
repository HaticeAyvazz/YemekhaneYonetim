package edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Repository.ımpl;

import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Repository.IFakulteRepository;
import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.entity.Fakulte;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
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
    public Fakulte save(Fakulte fakulte) {
        return entityManager.merge(fakulte);
    }

    @Override
    public void deleteById(Integer id) {
        findById(id).ifPresent(fakulte->entityManager.remove(fakulte));
    }

    @Override
    public Optional<Fakulte> findById(Integer id) {
        Fakulte fakulte = entityManager.find(Fakulte.class,id);
        return Optional.ofNullable(fakulte);
    }

}
