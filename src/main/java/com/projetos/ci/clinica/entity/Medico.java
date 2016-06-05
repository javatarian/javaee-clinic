/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetos.ci.clinica.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author gmatuella
 */
@Entity
@Table(name = "medico")
public class Medico extends Usuario implements Serializable {

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
    private String especialidades;

    public Medico() {
    }

    public String getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(String especialidades) {
        this.especialidades = especialidades;
    }

}
