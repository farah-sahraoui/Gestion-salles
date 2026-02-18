package com.example.service;

import com.example.model.Utilisateur;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class UtilisateurService extends AbstractCrudService<Utilisateur, Long> {

    public UtilisateurService(EntityManagerFactory emf) {
        super(emf);
    }

    public Optional<Utilisateur> rechercherParEmail(String email) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Utilisateur> q = em.createQuery(
                    "FROM Utilisateur u WHERE u.email = :mail", Utilisateur.class);
            q.setParameter("mail", email);

            List<Utilisateur> list = q.getResultList();
            return list.stream().findFirst();
        } finally {
            em.close();
        }
    }
}
