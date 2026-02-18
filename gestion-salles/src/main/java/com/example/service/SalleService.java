package com.example.service;

import com.example.model.Salle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class SalleService extends AbstractCrudService<Salle, Long> {

    public SalleService(EntityManagerFactory emf) {
        super(emf);
    }

    public List<Salle> listerDisponibles(boolean etat) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Salle> query = em.createQuery(
                    "FROM Salle s WHERE s.disponible = :etat", Salle.class);
            query.setParameter("etat", etat);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Salle> sallesAvecCapaciteMin(int min) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Salle> query = em.createQuery(
                    "FROM Salle s WHERE s.capacite >= :min", Salle.class);
            query.setParameter("min", min);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
