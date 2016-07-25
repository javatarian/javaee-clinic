/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmatuella.clinic.controller;

import com.gmatuella.clinic.entity.Doctor;
import com.gmatuella.clinic.exception.GenericServiceException;
import com.gmatuella.clinic.service.DoctorService;
import com.gmatuella.clinic.util.ClinicUtil;
import com.gmatuella.clinic.util.SecurityUtil;
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
public class DoctorBean {

    @EJB
    private DoctorService doctorService;

    private Doctor registeredDoctor, pickedDoctor;
    private List<Doctor> doctors, filteredDoctors;
    private ClinicUtil clinicUtil;
    private SecurityUtil securityUtil;

    @PostConstruct
    public void init() {
        registeredDoctor = new Doctor();
        pickedDoctor = new Doctor();
        doctors = doctorService.findAllActive();
        clinicUtil = ClinicUtil.getInstance();
        securityUtil = SecurityUtil.getInstance();
    }

    public void registerDoctor() throws GenericServiceException {
        registeredDoctor.setStatus(Boolean.TRUE);
        registeredDoctor.setPassword(securityUtil.createHash(registeredDoctor.getPassword()));
        
        doctorService.save(registeredDoctor);
        doctors = doctorService.findAllActive();
        registeredDoctor = new Doctor();

        clinicUtil.executeOnContext("PF('dialogRegisterDoctor').hide();");
        clinicUtil.addMessage("Doctor successfully registered!");
    }

    public void editDoctor() throws GenericServiceException {
        doctorService.update(pickedDoctor);
        doctors = doctorService.findAllActive();

        clinicUtil.executeOnContext("PF('dialogShowDoctor').hide();");
        clinicUtil.addMessage("Doctor sucessfully edited!");
    }

    public void deactivateDoctor() throws GenericServiceException {
        pickedDoctor.setStatus(Boolean.FALSE);
        doctorService.update(pickedDoctor);
        doctors = doctorService.findAllActive();

        clinicUtil.executeOnContext("PF('dialogShowDoctor').hide();");
        clinicUtil.addMessage("Doctor successfully deactivated!");
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
