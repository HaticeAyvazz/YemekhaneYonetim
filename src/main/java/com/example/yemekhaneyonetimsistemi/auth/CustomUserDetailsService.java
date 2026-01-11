package com.example.yemekhaneyonetimsistemi.auth;

import com.example.yemekhaneyonetimsistemi.entity.Kullanici;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            //Db den kullanıcı çekilir
            TypedQuery<Kullanici> query = entityManager.createQuery(
                    "SELECT k FROM Kullanici k WHERE k.kullaniciAdi = :username",
                    Kullanici.class
            );
            query.setParameter("username", username);
            Kullanici kullanici = query.getSingleResult();
            return new CustomUserDetails(kullanici);

        } catch (NoResultException e) {
            throw new UsernameNotFoundException("Kullanıcı adı sistemde bulunamadı: " + username);
        }
    }
}
