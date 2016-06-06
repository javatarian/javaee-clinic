/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetos.ci.clinica.entity;

import java.io.Serializable;
import java.util.Objects;
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
    private String especialidades;

    public Medico() {
    }

    public Medico(String especialidades, Long id, String nome, String rg, String telefone, String celular, String endereco, String login, String senha, String tipoAcesso, Boolean status) {
        super(id, nome, rg, telefone, celular, endereco, login, senha, tipoAcesso, status);
        this.especialidades = especialidades;
    }

    public String getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(String especialidades) {
        this.especialidades = especialidades;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.especialidades);
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
        final Medico other = (Medico) obj;
        if (!Objects.equals(this.especialidades, other.especialidades)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

}
