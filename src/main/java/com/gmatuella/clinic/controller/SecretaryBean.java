/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmatuella.clinic.controller;

import com.gmatuella.clinic.entity.Secretary;
import com.gmatuella.clinic.service.SecretaryService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
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
        
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dialogRegisterSecretary').hide();");
        addMessage("Secretary successfully registered!");
    }

    public void editSecretary() {
        new SecretaryService().update(pickedSecretary);
        secretaries = new SecretaryService().findAll();
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dialogShowSecretary').hide();");
        addMessage("Secretary successfully edited!");
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void onRowSelect(SelectEvent event) {
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
