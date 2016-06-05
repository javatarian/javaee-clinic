/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetos.ci.clinica.dao;

import com.projetos.ci.clinica.entity.Consulta;
import javax.persistence.EntityManager;

/**
 *
 * @author gmatuella
 */
public class ConsultaDAO extends GenericDAO<Long, Consulta> {

    public ConsultaDAO(EntityManager entityManager) {
        super(entityManager);
    }

}
