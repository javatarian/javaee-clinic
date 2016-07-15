/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmatuella.clinic.controller;

import com.gmatuella.clinic.entity.Appointment;
import com.gmatuella.clinic.service.AppointmentService;
import com.gmatuella.clinic.util.ClinicUtil;
import java.util.Collection;
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
public class AppointmentBean {

    @EJB
    private AppointmentService appointmentService;
    
    private Appointment pickedAppointment, registeredAppointment;
    private List<Appointment> appointments, filteredAppointments;
    private ClinicUtil clinicUtil;

    @PostConstruct
    public void init() {
        registeredAppointment = new Appointment();
        pickedAppointment = new Appointment();
        appointments = appointmentService.findAll();
        clinicUtil = ClinicUtil.getInstance();
    }

    public void registerAppointment() {
        registeredAppointment.setStatus(Boolean.TRUE);
        appointmentService.save(registeredAppointment);
        appointments = appointmentService.findAll();
        registeredAppointment = new Appointment();
        
        clinicUtil.executeOnContext("PF('dialogRegisterAppointment').hide()");
        clinicUtil.addMessage("Appointment successfully registered!");
    }

    public void editAppointment() {
        appointmentService.update(pickedAppointment);
        appointments = appointmentService.findAll();

        clinicUtil.executeOnContext("PF('dialogShowAppointment').hide();");
        clinicUtil.addMessage("Appointment sucessfully edited!");
    }

    public void openAppointment(Appointment consulta) {
        //Not implemented yet!!!
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

    public List<Appointment> getFilteredAppointments() {
        return filteredAppointments;
    }

    public void setFilteredAppointments(List<Appointment> filteredAppointments) {
        this.filteredAppointments = filteredAppointments;
    }
}
