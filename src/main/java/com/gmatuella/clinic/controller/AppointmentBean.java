/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmatuella.clinic.controller;

import com.gmatuella.clinic.entity.Appointment;
import com.gmatuella.clinic.service.AppointmentService;
import com.gmatuella.clinic.util.ClinicUtil;
import java.time.LocalDateTime;
import java.util.Collection;
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
public class AppointmentBean {

    private Appointment pickedAppointment, registeredAppointment;
    private List<Appointment> appointments, doneAppointments, filteredAppointments;
    private String testeString;
    private LocalDateTime testeldt;
    private ClinicUtil clinicUtil;

    @PostConstruct
    public void init() {
        registeredAppointment = new Appointment();
        pickedAppointment = new Appointment();
        appointments = new AppointmentService().findAll();
        clinicUtil = ClinicUtil.getInstance();
    }

    public void registerAppointment() {
        registeredAppointment.setStatus(Boolean.TRUE);
        new AppointmentService().save(registeredAppointment);
        appointments = new AppointmentService().findAll();
        

        clinicUtil.executeOnContext("PF('dialogRegisterAppointment').hide()");
        clinicUtil.addMessage("Appointment successfully registered!");
    }

    public void editAppointment() {

    }

    public void openAppointment(Appointment consulta) {
//        long diferencaDeTempo = Duration.between(consulta.getDataConsulta(), LocalDateTime.now()).getSeconds();
        long diferencaDeTempo = 1000L;
        if (diferencaDeTempo < 1800) {
            clinicUtil.executeOnContext("PF('dialogOpenAppointment').show()");
        } else {
            clinicUtil.addMessage("It wasn't possible to open the appointment!");
        }
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
