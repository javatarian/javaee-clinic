/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetos.ci.clinica.service;

import com.projetos.ci.clinica.dao.PacienteDAO;
import com.projetos.ci.clinica.entity.Paciente;
import com.projetos.ci.clinica.util.ClinicaEntityManager;
import java.util.List;

/**
 *
 * @author gmatuella
 */
public class PacienteService {

    private PacienteDAO dao;
    private ClinicaEntityManager cem;

    public PacienteService(ClinicaEntityManager cem) {
        this.cem = cem;
        dao = new PacienteDAO(this.cem.getEntityManager());
    }

    public void save(Paciente paciente) {
        try {
            cem.beginTransaction();
            dao.save(paciente);
            cem.commit();
        } catch (Exception e) {
            cem.rollBack();
        } finally {
            if (cem != null) {
                cem.close();
            }
        }
    }

    public void edit(Paciente paciente) {
        try {
            cem.beginTransaction();
            dao.update(paciente);
            cem.commit();
        } catch (Exception e) {
            cem.rollBack();
        } finally {
            if (cem != null) {
                cem.close();
            }
        }
    }

    public void remove(Paciente paciente) {
        try {
            cem.beginTransaction();
            dao.delete(dao.getById(paciente.getId()));
            cem.commit();
        } catch (Exception e) {
            cem.rollBack();
        } finally {
            if (cem != null) {
                cem.close();
            }
        }
    }

    public List<Paciente> findAll() {
        return dao.findAll();
    }

    public Paciente findPaciente(Long id) {
        return dao.getById(id);
    }
}
