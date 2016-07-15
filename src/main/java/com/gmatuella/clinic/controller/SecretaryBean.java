/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmatuella.clinic.controller;

import com.gmatuella.clinic.entity.Secretary;
import com.gmatuella.clinic.service.SecretaryService;
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
public class SecretaryBean {
    
    @EJB
    private SecretaryService secretaryService;
    
    private Secretary registeredSecretary, pickedSecretary;
    private List<Secretary> secretaries, filteredSecretaries;
    private ClinicUtil clinicUtil;

    @PostConstruct
    public void init() {
        registeredSecretary = new Secretary();
        pickedSecretary = new Secretary();
        secretaries = secretaryService.findAll();
        clinicUtil = ClinicUtil.getInstance();
    }

    public void registerSecretary() {
        registeredSecretary.setStatus(Boolean.TRUE);
        secretaryService.save(registeredSecretary);
        secretaries = secretaryService.findAll();
        registeredSecretary = new Secretary();
        
        clinicUtil.executeOnContext("PF('dialogRegisterSecretary').hide();");
        clinicUtil.addMessage("Secretary successfully registered!");
    }

    public void editSecretary() {
        secretaryService.update(pickedSecretary);
        secretaries = secretaryService.findAll();
        
        clinicUtil.executeOnContext("PF('dialogShowSecretary').hide();");
        clinicUtil.addMessage("Secretary successfully edited!");
    }

    public Secretary getRegisteredSecretary() {
        return registeredSecretary;
    }

    public void setRegisteredSecretary(Secretary registeredSecretary) {
        this.registeredSecretary = registeredSecretary;
    }

    public Secretary getPickedSecretary() {
        return pickedSecretary;
    }

    public void setPickedSecretary(Secretary pickedSecretary) {
        this.pickedSecretary = pickedSecretary;
    }

    public List<Secretary> getSecretaries() {
        return secretaries;
    }

    public void setSecretaries(List<Secretary> secretaries) {
        this.secretaries = secretaries;
    }

    public List<Secretary> getFilteredSecretaries() {
        return filteredSecretaries;
    }

    public void setFilteredSecretaries(List<Secretary> filteredSecretaries) {
        this.filteredSecretaries = filteredSecretaries;
    }
}
