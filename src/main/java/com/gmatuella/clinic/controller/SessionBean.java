/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmatuella.clinic.controller;

import com.gmatuella.clinic.entity.Administrator;
import com.gmatuella.clinic.entity.Doctor;
import com.gmatuella.clinic.entity.Secretary;
import com.gmatuella.clinic.service.AdministratorService;
import com.gmatuella.clinic.service.DoctorService;
import com.gmatuella.clinic.service.SecretaryService;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.validation.constraints.Size;

/**
 *
 * @author gmatuella
 */
@Named
@SessionScoped
public class SessionBean implements Serializable {

    @Size(min = 4, max = 20)
    private String login;

    @Size(min = 4, max = 30)
    private String password;

    private Administrator administrator;
    private Doctor doctor;
    private Secretary secretary;
    private Boolean logged;

    @PostConstruct
    public void init() {
        logged = Boolean.FALSE;
    }

    public String logIn() {
        SecretaryService secService = new SecretaryService();
        for (Secretary registeredSecretary : secService.findAll()) {
            if (registeredSecretary.getLogin().equals(login) && registeredSecretary.getPassword().equals(password)) {
                secretary = registeredSecretary;
                logged = true;
                return "appointments.xhtml?faces-redirect=true";
            }
        }
        DoctorService docService = new DoctorService();
        for (Doctor registeredDoctor : docService.findAll()) {
            if (registeredDoctor.getLogin().equals(login) && registeredDoctor.getPassword().equals(password)) {
                doctor = registeredDoctor;
                logged = true;
                return "appointments.xhtml?faces-redirect=true";
            }
        }
        AdministratorService admService = new AdministratorService();
        for (Administrator registeredAdministrator : admService.findAll()) {
            if (registeredAdministrator.getLogin().equals(login) && registeredAdministrator.getPassword().equals(password)) {
                administrator = registeredAdministrator;
                logged = true;
                return "dashboard.xhtml?faces-redirect=true";
            }
        }
        addMessage("Invalid User and/or Password!"); //Retornar algo que não refresh a pag
        return "";
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login.xhtml?faces-redirect=true";
    }

    public boolean isAdmin() {
        return administrator != null;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Secretary getSecretary() {
        return secretary;
    }

    public void setSecretary(Secretary secretary) {
        this.secretary = secretary;
    }

    public Boolean getLogged() {
        return logged;
    }

    public void setLogged(Boolean logged) {
        this.logged = logged;
    }

}
