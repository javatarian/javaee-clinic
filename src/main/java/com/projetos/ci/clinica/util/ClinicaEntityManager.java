/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetos.ci.clinica.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author gmatuella
 */
public class ClinicaEntityManager {

    private EntityManager manager;
    private EntityManagerFactory factory;

    public ClinicaEntityManager(EntityManagerFactory factory) {
        this.factory = factory;
        this.manager = factory.createEntityManager();
    }

    public ClinicaEntityManager(String persistenceUnitName) {
        factory = Persistence.createEntityManagerFactory(persistenceUnitName);
        this.manager = factory.createEntityManager();
    }

    public void beginTransaction() {
        manager.getTransaction().begin();
    }

    public void commit() {
        manager.getTransaction().commit();
    }

    public void close() {
        manager.close();
        factory.close();
    }

    public void rollBack() {
        manager.getTransaction().rollback();
    }

    public EntityManager getEntityManager() {
        return manager;
    }

}
