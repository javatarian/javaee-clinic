/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmatuella.clinic.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author gmatuella
 */
//This class is a Singleton. But not a simple one,
//it has a lazy initialization and is thread safe
public class EntityManagerUtil {
    
    private static EntityManagerUtil instance;
    private final EntityManagerFactory factory;

    public static synchronized EntityManagerUtil getInstance() {
        if (instance == null) {
            instance = new EntityManagerUtil();
        }
        return instance;
    }

    private EntityManagerUtil() {
        this.factory = Persistence.createEntityManagerFactory("ClinicPU");
    }

    public EntityManager createManager() {
        return factory.createEntityManager();
    }

}
