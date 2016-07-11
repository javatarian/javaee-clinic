/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmatuella.clinic.controller;

import com.gmatuella.clinic.entity.Doctor;
import com.gmatuella.clinic.service.DoctorService;
import com.gmatuella.clinic.util.ClinicUtil;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author gmatuella
 */
@Named
@RequestScoped
public class DoctorBean {

    @EJB
    private DoctorService doctorService;
    private Doctor registeredDoctor, pickedDoctor;
    private List<Doctor> doctors, filteredDoctors;

    @PostConstruct
    public void init() {
        registeredDoctor = new Doctor();
        pickedDoctor = new Doctor();
        doctors = doctorService.findAll();
    }

    public void registerDoctor() {
        registeredDoctor.setStatus(Boolean.TRUE);
        doctorService.save(registeredDoctor);
        doctors = doctorService.findAll();

        ClinicUtil.getInstance().executeOnContext("PF('dialogRegisterDoctor').hide();");
        ClinicUtil.getInstance().addMessage("Doctor successfully registered!");
    }

    public void editDoctor() {
        doctorService.update(pickedDoctor);
        doctors = doctorService.findAll();

        ClinicUtil.getInstance().executeOnContext("PF('dialogShowDoctor').hide();");
        ClinicUtil.getInstance().addMessage("Doctor sucessfully edited!");
    }

    public void deletarMedico() {
        doctorService.delete(pickedDoctor);
        doctors = doctorService.findAll();

        ClinicUtil.getInstance().executeOnContext("PF('dialogShowDoctor').hide();");
        ClinicUtil.getInstance().addMessage("Doctor sucessfully removed!");
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
