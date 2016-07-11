/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmatuella.clinic.service;

import com.gmatuella.clinic.entity.Pacient;
import javax.ejb.Stateless;

/**
 *
 * @author gmatuella
 */
@Stateless
public class PacientService extends GenericService<Pacient> {

    public PacientService() {
        super(Pacient.class);
    }
}
