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
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author gmatuella
 */
@Named
@RequestScoped
public class SecretaryBean {
    
    private Secretary registeredSecretary, pickedSecretary;
    private List<Secretary> secretaries, filteredSecretaries;

    @PostConstruct
    public void init() {
        registeredSecretary = new Secretary();
        pickedSecretary = new Secretary();
        secretaries = new SecretaryService().findAll();
    }

    public void registerSecretary() {
        registeredSecretary.setStatus(Boolean.TRUE);
        new SecretaryService().save(registeredSecretary);
        secretaries = new SecretaryService().findAll();
        registeredSecretary = new Secretary();
        
        ClinicUtil.getInstance().executeOnContext("PF('dialogRegisterSecretary').hide();");
        ClinicUtil.getInstance().addMessage("Secretary successfully registered!");
    }

    public void editSecretary() {
        new SecretaryService().update(pickedSecretary);
        secretaries = new SecretaryService().findAll();
        
        ClinicUtil.getInstance().executeOnContext("PF('dialogShowSecretary').hide();");
        ClinicUtil.getInstance().addMessage("Secretary successfully edited!");
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
