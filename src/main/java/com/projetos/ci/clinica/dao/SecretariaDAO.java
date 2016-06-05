/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetos.ci.clinica.dao;

import com.projetos.ci.clinica.entity.Secretaria;
import javax.persistence.EntityManager;

/**
 *
 * @author gmatuella
 */
public class SecretariaDAO extends GenericDAO<Long, Secretaria> {

    public SecretariaDAO(EntityManager entityManager) {
        super(entityManager);
    }

}
