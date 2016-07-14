/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmatuella.clinic.controller;

import com.gmatuella.clinic.entity.Pacient;
import com.gmatuella.clinic.service.PacientService;
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
public class PacientBean {
    
    private Pacient registeredPacient, pickedPacient;
    private List<Pacient> pacients, filteredPacients;

    @PostConstruct
    public void init() {
        registeredPacient = new Pacient();
        pickedPacient = new Pacient();
        pacients = new PacientService().findAll();
    }

    public void registerPacient() {
        new PacientService().save(registeredPacient);
        pacients = new PacientService().findAll();
        registeredPacient = new Pacient();

        ClinicUtil.getInstance().executeOnContext("PF('dialogRegisterPacient').hide();");
        ClinicUtil.getInstance().addMessage("Pacient successfully registered!");
    }

    public void editPacient() {
        new PacientService().update(pickedPacient);
        pacients = new PacientService().findAll();

        ClinicUtil.getInstance().executeOnContext("PF('dialogShowPacient').hide();");
        ClinicUtil.getInstance().addMessage("Pacient successfully edited!");
    }

    public void onRowSelect(SelectEvent event) {
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
