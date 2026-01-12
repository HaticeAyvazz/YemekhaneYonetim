package edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Repository.ımpl;

import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.Repository.IMenuRepository;
import edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.entity.Menu;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MenuRepositoryImpl implements IMenuRepository {

    private final EntityManager entityManager;

    public MenuRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Menu> getAll() {
        TypedQuery<Menu> query=entityManager.createQuery("Select m from Menu m",Menu.class);
        return query.getResultList();
    }

    @Override
    public Menu save(Menu menu) {
        return entityManager.merge(menu);
    }

    @Override
    public void deleteById(Integer id) {
      Menu menu=entityManager.find(Menu.class,id);
      if(menu!=null){
          entityManager.remove(menu);
      }

    }


    @Override
    public Optional<Menu> findById(Integer id) {
        Menu menu = entityManager.find(Menu.class, id);
        return Optional.ofNullable(menu);
    }


}
