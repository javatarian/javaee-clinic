/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmatuella.clinic.controller;

import com.gmatuella.clinic.entity.Pacient;
import com.gmatuella.clinic.exception.GenericServiceException;
import com.gmatuella.clinic.service.PacientService;
import com.gmatuella.clinic.util.ClinicUtil;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author gmatuella
 */
@Named
@RequestScoped
public class PacientBean {
    
    @EJB
    private PacientService pacientService;
    
    private Pacient registeredPacient, pickedPacient;
    private List<Pacient> pacients, filteredPacients;
    private ClinicUtil clinicUtil;

    @PostConstruct
    public void init() {
        registeredPacient = new Pacient();
        pickedPacient = new Pacient();
        pacients = pacientService.findAll();
        clinicUtil = ClinicUtil.getInstance();
    }

    public void registerPacient() throws GenericServiceException {
        pacientService.save(registeredPacient);
        pacients = pacientService.findAll();
        registeredPacient = new Pacient();
        
        clinicUtil.executeOnContext("PF('dialogRegisterPacient').hide();");
        clinicUtil.addMessage("Pacient successfully registered!");
    }

    public void editPacient() throws GenericServiceException {
        pacientService.update(pickedPacient);
        pacients = pacientService.findAll();

        clinicUtil.executeOnContext("PF('dialogShowPacient').hide();");
        clinicUtil.addMessage("Pacient successfully edited!");
    }
    
    public Pacient getRegisteredPacient() {
        return registeredPacient;
    }

    public void setRegisteredPacient(Pacient registeredPacient) {
        this.registeredPacient = registeredPacient;
    }

    public Pacient getPickedPacient() {
        return pickedPacient;
    }

    public void setPickedPacient(Pacient pickedPacient) {
        this.pickedPacient = pickedPacient;
    }

    public List<Pacient> getFilteredPacients() {
        return filteredPacients;
    }

    public void setFilteredPacients(List<Pacient> filteredPacients) {
        this.filteredPacients = filteredPacients;
    }

    public List<Pacient> getPacients() {
        return pacients;
    }

    public void setPacients(List<Pacient> pacients) {
        this.pacients = pacients;
    }

}
