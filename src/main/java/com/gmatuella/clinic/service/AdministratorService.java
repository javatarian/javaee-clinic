/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmatuella.clinic.service;

import com.gmatuella.clinic.entity.Administrator;
import javax.ejb.Stateless;

/**
 *
 * @author gmatuella
 */
@Stateless
public class AdministratorService extends GenericService<Administrator> {

    public AdministratorService() {
        super(Administrator.class);
    }
}
