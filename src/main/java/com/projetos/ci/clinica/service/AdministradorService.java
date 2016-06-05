/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetos.ci.clinica.service;

import com.projetos.ci.clinica.dao.AdministradorDAO;
import com.projetos.ci.clinica.entity.Administrador;
import com.projetos.ci.clinica.util.ClinicaEntityManager;
import java.util.List;

/**
 *
 * @author gmatuella
 */
public class AdministradorService {

    private AdministradorDAO dao;
    private ClinicaEntityManager cem;

    public AdministradorService(ClinicaEntityManager cem) {
        this.cem = cem;
        dao = new AdministradorDAO(this.cem.getEntityManager());
    }

    public void save(Administrador administrador) {
        try {
            cem.beginTransaction();
            dao.save(administrador);
            cem.commit();
        } catch (Exception e) {
            cem.rollBack();
        } finally {
            if (cem != null) {
                cem.close();
            }
        }
    }

    public void edit(Administrador administrador) {
        try {
            cem.beginTransaction();
            dao.update(administrador);
            cem.commit();
        } catch (Exception e) {
            cem.rollBack();
        } finally {
            if (cem != null) {
                cem.close();
            }
        }
    }

    public void remove(Administrador administrador) {
        try {
            cem.beginTransaction();
            dao.delete(dao.getById(administrador.getId()));
            cem.commit();
        } catch (Exception e) {
            cem.rollBack();
        } finally {
            if (cem != null) {
                cem.close();
            }
        }
    }

    public List<Administrador> findAll() {
        return dao.findAll();
    }
}
