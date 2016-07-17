/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmatuella.clinic.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author gmatuella
 */
@Entity
@Table(name = "doctor")
public class Doctor extends User implements Serializable {

    //Código que posteriormente poderá ser utilizado para refatorar a ideia das
    //especialidades de um médico.
    //
//    @ElementCollection
//    @CollectionTable(name = "Especialidades", joinColumns = @JoinColumn(name = "id"))
//    @Column(name = "especialidade")
//    private List<String> especialidades;
//
//    public List<String> getEspecialidades() {
//        return especialidades;
//    }
//
//    public void setEspecialidades(List<String> especialidades) {
//        this.especialidades = especialidades;
//    }
    @Column(length = 1000, nullable = false)
    private String specialties;

    public Doctor() {
    }

    public Doctor(String specialties, Long id, String name, String phone, String address, LocalDate birthDate, String login, String password, Boolean status) {
        super(id, name, phone, address, birthDate, login, password, status);
        this.specialties = specialties;
    }

    public String getSpecialties() {
        return specialties;
    }

    public void setSpecialties(String specialties) {
        this.specialties = specialties;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.specialties);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Doctor other = (Doctor) obj;
        if (!Objects.equals(this.specialties, other.specialties)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
