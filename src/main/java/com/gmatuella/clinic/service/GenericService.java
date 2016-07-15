/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmatuella.clinic.service;

import com.gmatuella.clinic.util.EntityManagerUtil;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Guilherme
 */
//A simple Generic Service that contains the singleton of the EM util. 
//If needed, the subclass that extends this Generic can easily use the
//protected fields to create specific methods.
public class GenericService<T> {

    protected EntityManagerUtil entityManagerUtil;
    protected final Class<T> typeClass;

    public GenericService(Class<T> typeClass) {
        this.entityManagerUtil = EntityManagerUtil.getInstance();
        this.typeClass = typeClass;
    }

    public void save(T entity) {
        EntityManager entityManager = entityManagerUtil.createManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    public void update(T entity) {
        EntityManager entityManager = entityManagerUtil.createManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    public void delete(T entity) {
        EntityManager entityManager = entityManagerUtil.createManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    public T findById(Long id) {
        EntityManager entityManager = entityManagerUtil.createManager();
        try {
            return (T) entityManager.find(typeClass, id);
        } catch (Exception e) {

        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return null;
    }

    public List<T> findAll() {
        EntityManager entityManager = entityManagerUtil.createManager();
        List<T> tList = entityManager.createQuery(("FROM " + typeClass.getName()))
                .getResultList();
        entityManager.close();

        return tList;
    }

    //This method is kind of odd to be generic, but all the entities have the same
    //field name for defining its current STATUS (redundant, isn't it?).
    public List<T> findAllActive() {
        EntityManager entityManager = entityManagerUtil.createManager();
        List<T> tList = entityManager.createQuery(("FROM " + typeClass.getName() + " WHERE status = 1"))
                .getResultList();
        entityManager.close();

        return tList;
    }
}
