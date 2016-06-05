/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetos.ci.clinica.service;

import com.projetos.ci.clinica.dao.MedicoDAO;
import com.projetos.ci.clinica.entity.Medico;
import com.projetos.ci.clinica.util.ClinicaEntityManager;
import java.util.List;

/**
 *
 * @author gmatuella
 */
public class MedicoService {

    private MedicoDAO dao;
    private ClinicaEntityManager cem;

    public MedicoService(ClinicaEntityManager cem) {
        this.cem = cem;
        dao = new MedicoDAO(this.cem.getEntityManager());
    }

    public void save(Medico medico) {
        try {
            cem.beginTransaction();
            dao.save(medico);
            cem.commit();
        } catch (Exception e) {
            cem.rollBack();
        } finally {
            if (cem != null) {
                cem.close();
            }
        }
    }

    public void edit(Medico medico) {
        try {
            cem.beginTransaction();
            dao.update(medico);
            cem.commit();
        } catch (Exception e) {
            cem.rollBack();
        } finally {
            if (cem != null) {
                cem.close();
            }
        }
    }

    public void remove(Medico medico) {
        try {
            cem.beginTransaction();
            dao.delete(dao.getById(medico.getId()));
            cem.commit();
        } catch (Exception e) {
            cem.rollBack();
        } finally {
            if (cem != null) {
                cem.close();
            }
        }
    }

    public List<Medico> findAll() {
        return dao.findAll();
    }
}
