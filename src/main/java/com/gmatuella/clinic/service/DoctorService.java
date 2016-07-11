/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmatuella.clinic.service;

import com.gmatuella.clinic.entity.Doctor;
import javax.ejb.Stateless;

/**
 *
 * @author gmatuella
 */
@Stateless
public class DoctorService extends GenericService<Doctor>{

    public DoctorService() {
        super(Doctor.class);
    }
}
