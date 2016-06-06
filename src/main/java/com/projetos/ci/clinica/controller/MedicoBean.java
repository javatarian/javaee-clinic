/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetos.ci.clinica.controller;

import com.projetos.ci.clinica.entity.Medico;
import com.projetos.ci.clinica.service.MedicoService;
import com.projetos.ci.clinica.util.ClinicaEntityManager;
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
public class MedicoBean {

    private Medico medicoCadastrado, medicoSelecionado;
    private List<Medico> medicos, medicosFiltrados;

    @PostConstruct
    public void init() {
        medicoCadastrado = new Medico();
        medicoSelecionado = new Medico();
        medicos = new MedicoService(new ClinicaEntityManager("ClinicaPU")).findAll();
    }

    public void cadastrarMedico() {
        medicoCadastrado.setTipoAcesso("3");
        medicoCadastrado.setStatus(Boolean.TRUE);
        new MedicoService(new ClinicaEntityManager("ClinicaPU")).save(medicoCadastrado);
        medicos = new MedicoService(new ClinicaEntityManager("ClinicaPU")).findAll();
        medicoSelecionado = new Medico();
        
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dialogCadastroMedico').hide();");
        addMessage("Médico cadastrado com sucesso!");
    }

    public void editarMedico() {
        new MedicoService(new ClinicaEntityManager("ClinicaPU")).edit(medicoSelecionado);
        medicos = new MedicoService(new ClinicaEntityManager("ClinicaPU")).findAll();
        
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dialogVisualizaMedico').hide();");
        addMessage("Médico editado com sucesso!");
    }

    public void deletarMedico() {
        new MedicoService(new ClinicaEntityManager("ClinicaPU")).remove(medicoSelecionado);
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

    public Medico getMedicoCadastrado() {
        return medicoCadastrado;
    }

    public void setMedicoCadastrado(Medico medicoCadastrado) {
        this.medicoCadastrado = medicoCadastrado;
    }

    public Medico getMedicoSelecionado() {
        return medicoSelecionado;
    }

    public void setMedicoSelecionado(Medico medicoSelecionado) {
        this.medicoSelecionado = medicoSelecionado;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }

    public List<Medico> getMedicosFiltrados() {
        return medicosFiltrados;
    }

    public void setMedicosFiltrados(List<Medico> medicosFiltrados) {
        this.medicosFiltrados = medicosFiltrados;
    }

}
