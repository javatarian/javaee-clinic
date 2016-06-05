/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetos.ci.clinica.controller;

import com.projetos.ci.clinica.entity.Secretaria;
import com.projetos.ci.clinica.service.SecretariaService;
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
public class SecretariaBean {

    private Secretaria secretariaCadastrada, secretariaSelecionada;
    private List<Secretaria> secretarias, secretariasFiltradas;
    
    @PostConstruct
    public void init() {
        secretariaCadastrada = new Secretaria();
        secretariaSelecionada = new Secretaria();
        secretarias = new SecretariaService(new ClinicaEntityManager("ClinicaPU")).findAll();
    }

    public void cadastrarSecretaria() {
        new SecretariaService(new ClinicaEntityManager("ClinicaPU")).edit(secretariaCadastrada);
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dialogCadastroSecretaria').hide();");
        addMessage("Secretaria cadastrada com sucesso!");
    }
    
    public void editarSecretaria() {
        new SecretariaService(new ClinicaEntityManager("ClinicaPU")).save(secretariaSelecionada);
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dialogVisualizaMedico').hide();");
        addMessage("Secretaria editada com sucesso!");
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void onRowSelect(SelectEvent event) {
    }
}