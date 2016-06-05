/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetos.ci.clinica.dao;

import com.projetos.ci.clinica.entity.Paciente;
import javax.persistence.EntityManager;

/**
 *
 * @author gmatuella
 */
public class PacienteDAO extends GenericDAO<Long, Paciente> {

    public PacienteDAO(EntityManager entityManager) {
        super(entityManager);
    }
    
}
