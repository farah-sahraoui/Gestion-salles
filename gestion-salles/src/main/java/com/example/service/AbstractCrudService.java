package com.example.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

public abstract class AbstractCrudService<T, ID> implements CrudService<T, ID> {

    protected EntityManagerFactory emf;
    protected Class<T> entityType;

    @SuppressWarnings("unchecked")
    public AbstractCrudService(EntityManagerFactory emf) {
        this.emf = emf;
        this.entityType = (Class<T>) ((ParameterizedType)
                getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    @Override
    public T create(T entity) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
            return entity;
        } catch (RuntimeException ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw ex;
        } finally {
            em.close();
        }
    }

    @Override
    public Optional<T> getById(ID id) {
        EntityManager em = emf.createEntityManager();
        try {
            return Optional.ofNullable(em.find(entityType, id));
        } finally {
            em.close();
        }
    }

    @Override
    public List<T> getAll() {
        EntityManager em = emf.createEntityManager();
        try {
            String jpql = "FROM " + entityType.getSimpleName();
            TypedQuery<T> query = em.createQuery(jpql, entityType);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public T edit(T entity) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            T merged = em.merge(entity);
            em.getTransaction().commit();
            return merged;
        } catch (RuntimeException ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw ex;
        } finally {
            em.close();
        }
    }

    @Override
    public void remove(T entity) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            T attached = em.contains(entity) ? entity : em.merge(entity);
            em.remove(attached);
            em.getTransaction().commit();
        } catch (RuntimeException ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw ex;
        } finally {
            em.close();
        }
    }

    @Override
    public void removeById(ID id) {
        getById(id).ifPresent(this::remove);
    }
}
