/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetos.ci.clinica.service;

import com.projetos.ci.clinica.dao.ConsultaDAO;
import com.projetos.ci.clinica.entity.Consulta;
import com.projetos.ci.clinica.util.ClinicaEntityManager;
import java.util.List;

/**
 *
 * @author gmatuella
 */
public class ConsultaService {

    private ConsultaDAO dao;
    private ClinicaEntityManager cem;

    public ConsultaService(ClinicaEntityManager cem) {
        this.cem = cem;
        dao = new ConsultaDAO(this.cem.getEntityManager());
    }

    public void save(Consulta consulta) {
        try {
            cem.beginTransaction();
            dao.save(consulta);
            cem.commit();
        } catch (Exception e) {
            cem.rollBack();
        } finally {
            if (cem != null) {
                cem.close();
            }
        }
    }

    public void edit(Consulta consulta) {
        try {
            cem.beginTransaction();
            dao.update(consulta);
            cem.commit();
        } catch (Exception e) {
            cem.rollBack();
        } finally {
            if (cem != null) {
                cem.close();
            }
        }
    }

    public void remove(Consulta consulta) {
        try {
            cem.beginTransaction();
            dao.delete(dao.getById(consulta.getId()));
            cem.commit();
        } catch (Exception e) {
            cem.rollBack();
        } finally {
            if (cem != null) {
                cem.close();
            }
        }
    }

    public List<Consulta> findAll() {
        return dao.findAll();
    }
}
