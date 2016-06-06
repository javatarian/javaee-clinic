/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetos.ci.clinica.controller;

import com.projetos.ci.clinica.entity.Paciente;
import com.projetos.ci.clinica.service.PacienteService;
import com.projetos.ci.clinica.util.ClinicaEntityManager;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.enterprise.context.RequestScoped;
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
public class PacienteBean {

    private Paciente pacienteCadastrado, pacienteSelecionado;
    private List<Paciente> pacientes, pacientesFiltrados;
    
    @PostConstruct
    public void init() {
        pacienteCadastrado = new Paciente();
        pacienteSelecionado = new Paciente();
        pacientes = new PacienteService(new ClinicaEntityManager("ClinicaPU")).findAll();
    }

    public void cadastrarPaciente() {
        new PacienteService(new ClinicaEntityManager("ClinicaPU")).save(pacienteCadastrado);
        pacientes = new PacienteService(new ClinicaEntityManager("ClinicaPU")).findAll();
        pacienteCadastrado = new Paciente();
        
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dialogCadastroPaciente').hide();");
        addMessage("Paciente cadastrado com sucesso!");
    }
    
    public void editarPaciente() {
        new PacienteService(new ClinicaEntityManager("ClinicaPU")).edit(pacienteSelecionado);
        pacientes = new PacienteService(new ClinicaEntityManager("ClinicaPU")).findAll();
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dialogVisualizaPaciente').hide();");
        addMessage("Paciente editado com sucesso!");
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void onRowSelect(SelectEvent event) {
    }

    public Paciente getPacienteCadastrado() {
        return pacienteCadastrado;
    }

    public void setPacienteCadastrado(Paciente pacienteCadastrado) {
        this.pacienteCadastrado = pacienteCadastrado;
    }

    public Paciente getPacienteSelecionado() {
        return pacienteSelecionado;
    }

    public void setPacienteSelecionado(Paciente pacienteSelecionado) {
        this.pacienteSelecionado = pacienteSelecionado;
    }

    public List<Paciente> getPacientesFiltrados() {
        return pacientesFiltrados;
    }

    public void setPacientesFiltrados(List<Paciente> pacientesFiltrados) {
        this.pacientesFiltrados = pacientesFiltrados;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

}
