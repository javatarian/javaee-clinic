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
        secretarias = new SecretariaService().findAll();
    }

    public void cadastrarSecretaria() {
        secretariaCadastrada.setTipoAcesso("2");
        secretariaCadastrada.setStatus(Boolean.TRUE);
        new SecretariaService().save(secretariaCadastrada);
        secretarias = new SecretariaService().findAll();
        secretariaCadastrada = new Secretaria();
        
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dialogCadastroSecretaria').hide();");
        addMessage("Secretária cadastrada com sucesso!");
    }

    public void editarSecretaria() {
        new SecretariaService().update(secretariaSelecionada);
        secretarias = new SecretariaService().findAll();
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dialogVisualizaSecretaria').hide();");
        addMessage("Secretária editada com sucesso!");
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void onRowSelect(SelectEvent event) {
    }

    public Secretaria getSecretariaCadastrada() {
        return secretariaCadastrada;
    }

    public void setSecretariaCadastrada(Secretaria secretariaCadastrada) {
        this.secretariaCadastrada = secretariaCadastrada;
    }

    public Secretaria getSecretariaSelecionada() {
        return secretariaSelecionada;
    }

    public void setSecretariaSelecionada(Secretaria secretariaSelecionada) {
        this.secretariaSelecionada = secretariaSelecionada;
    }

    public List<Secretaria> getSecretarias() {
        return secretarias;
    }

    public void setSecretarias(List<Secretaria> secretarias) {
        this.secretarias = secretarias;
    }

    public List<Secretaria> getSecretariasFiltradas() {
        return secretariasFiltradas;
    }

    public void setSecretariasFiltradas(List<Secretaria> secretariasFiltradas) {
        this.secretariasFiltradas = secretariasFiltradas;
    }
}
