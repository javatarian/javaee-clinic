/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetos.ci.clinica.dao;

import com.projetos.ci.clinica.entity.Administrador;
import javax.persistence.EntityManager;

/**
 *
 * @author gmatuella
 */
public class AdministradorDAO extends GenericDAO<Long, Administrador> {

    public AdministradorDAO(EntityManager entityManager) {
        super(entityManager);
    }

}
