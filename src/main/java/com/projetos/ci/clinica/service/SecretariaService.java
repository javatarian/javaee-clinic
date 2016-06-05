/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetos.ci.clinica.service;

import com.projetos.ci.clinica.dao.SecretariaDAO;
import com.projetos.ci.clinica.entity.Secretaria;
import com.projetos.ci.clinica.util.ClinicaEntityManager;
import java.util.List;

/**
 *
 * @author gmatuella
 */
public class SecretariaService {

    private SecretariaDAO dao;
    private ClinicaEntityManager cem;

    public SecretariaService(ClinicaEntityManager cem) {
        this.cem = cem;
        dao = new SecretariaDAO(this.cem.getEntityManager());
    }

    public void save(Secretaria secretaria) {
        try {
            cem.beginTransaction();
            dao.save(secretaria);
            cem.commit();
        } catch (Exception e) {
            cem.rollBack();
        } finally {
            if (cem != null) {
                cem.close();
            }
        }
    }

    public void edit(Secretaria secretaria) {
        try {
            cem.beginTransaction();
            dao.update(secretaria);
            cem.commit();
        } catch (Exception e) {
            cem.rollBack();
        } finally {
            if (cem != null) {
                cem.close();
            }
        }
    }

    public void remove(Secretaria secretaria) {
        try {
            cem.beginTransaction();
            dao.delete(dao.getById(secretaria.getId()));
            cem.commit();
        } catch (Exception e) {
            cem.rollBack();
        } finally {
            if (cem != null) {
                cem.close();
            }
        }
    }

    public List<Secretaria> findAll() {
        return dao.findAll();
    }
}
