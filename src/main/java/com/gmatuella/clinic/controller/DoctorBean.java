/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmatuella.clinic.controller;

import com.gmatuella.clinic.entity.Doctor;
import com.gmatuella.clinic.service.DoctorService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
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
public class DoctorBean {

    private Doctor registeredDoctor, pickedDoctor;
    private List<Doctor> doctors, filteredDoctors;

    @PostConstruct
    public void init() {
        registeredDoctor = new Doctor();
        pickedDoctor = new Doctor();
        doctors = new DoctorService().findAll();
    }

    public void cadastrarMedico() {
        registeredDoctor.setStatus(Boolean.TRUE);
        new DoctorService().save(registeredDoctor);
        doctors = new DoctorService().findAll();
        pickedDoctor = new Doctor();
        
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dialogCadastroMedico').hide();");
        addMessage("Médico cadastrado com sucesso!");
    }

    public void editarMedico() {
        new DoctorService().update(pickedDoctor);
        doctors = new DoctorService().findAll();
        
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dialogVisualizaMedico').hide();");
        addMessage("Médico editado com sucesso!");
    }

    public void deletarMedico() {
        new DoctorService().delete(pickedDoctor);
    }
    
//    public void listarMedicos() {
//        new MedicoService(new ClinicaEntityManager("ClinicaPU")).findAll();
//    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void onRowSelect(SelectEvent event) {
    }

    public Doctor getRegisteredDoctor() {
        return registeredDoctor;
    }

    public void setRegisteredDoctor(Doctor registeredDoctor) {
        this.registeredDoctor = registeredDoctor;
    }

    public Doctor getPickedDoctor() {
        return pickedDoctor;
    }

    public void setPickedDoctor(Doctor pickedDoctor) {
        this.pickedDoctor = pickedDoctor;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public List<Doctor> getFilteredDoctors() {
        return filteredDoctors;
    }

    public void setFilteredDoctors(List<Doctor> filteredDoctors) {
        this.filteredDoctors = filteredDoctors;
    }

}
