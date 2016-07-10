/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmatuella.clinic.controller;

import com.gmatuella.clinic.entity.Appointment;
import com.gmatuella.clinic.service.AppointmentService;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
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
public class AppointmentBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Appointment pickedAppointment, registeredAppointment;
    private List<Appointment> appointments, doneAppointments, filteredAppointments;
    private String testeString;
    private LocalDateTime testeldt;

    @PostConstruct
    public void init() {
        registeredAppointment = new Appointment();
        pickedAppointment = new Appointment();
        appointments = new AppointmentService().findAll();
    }

    public void registerAppointment() {
        new AppointmentService().save(registeredAppointment);
        appointments = new AppointmentService().findAll();
        registeredAppointment = new Appointment();

        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.execute("PF('dialogRegisterAppointment').hide()");
        addMessage("Appointment successfully registered!");
    }

    public void editAppointment() {

    }

    public void openAppointment(Appointment consulta) {
//        long diferencaDeTempo = Duration.between(consulta.getDataConsulta(), LocalDateTime.now()).getSeconds();
        long diferencaDeTempo = 1000L;
        if (diferencaDeTempo < 1800) {
            RequestContext requestContext = RequestContext.getCurrentInstance();
            requestContext.execute("PF('dialogOpenAppointment').show()");
        } else {
            addMessage("It wasn't possible to open the appointment!");
        }
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void onRowSelect(SelectEvent event) {
    }

    public Appointment getPickedAppointment() {
        return pickedAppointment;
    }

    public void setPickedAppointment(Appointment pickedAppointment) {
        this.pickedAppointment = pickedAppointment;
    }

    public Collection<Appointment> getAppointments() {
        return appointments;
    }

    public Appointment getRegisteredAppointment() {
        return registeredAppointment;
    }

    public void setRegisteredAppointment(Appointment registeredAppointment) {
        this.registeredAppointment = registeredAppointment;
    }

    public String getTesteString() {
        return testeString;
    }

    public void setTesteString(String testeString) {
        this.testeString = testeString;
    }

    public List<Appointment> getFilteredAppointments() {
        return filteredAppointments;
    }

    public void setFilteredAppointments(List<Appointment> filteredAppointments) {
        this.filteredAppointments = filteredAppointments;
    }

    public List<Appointment> getDoneAppointments() {
        return doneAppointments;
    }

    public void setDoneAppointments(List<Appointment> doneAppointments) {
        this.doneAppointments = doneAppointments;
    }

    public LocalDateTime getTesteldt() {
        return testeldt;
    }

    public void setTesteldt(LocalDateTime testeldt) {
        this.testeldt = testeldt;
    }
}
