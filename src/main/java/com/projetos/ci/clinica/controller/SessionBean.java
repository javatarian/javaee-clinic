/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetos.ci.clinica.controller;

import com.projetos.ci.clinica.entity.Administrador;
import com.projetos.ci.clinica.entity.Medico;
import com.projetos.ci.clinica.entity.Secretaria;
import com.projetos.ci.clinica.service.AdministradorService;
import com.projetos.ci.clinica.service.MedicoService;
import com.projetos.ci.clinica.service.SecretariaService;
import com.projetos.ci.clinica.util.ClinicaEntityManager;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.validation.constraints.Size;

/**
 *
 * @author gmatuella
 */
@Named
@SessionScoped
public class SessionBean implements Serializable {

    @Size(min = 4, max = 20)
    private String login;

    @Size(min = 4, max = 30)
    private String senha;

    private Administrador administrador;
    private Medico medico;
    private Secretaria secretaria;
    private Boolean logado;

    @PostConstruct
    public void init() {
        logado = Boolean.FALSE;
    }

    public String logar() {
        SecretariaService secService = new SecretariaService(new ClinicaEntityManager("ClinicaPU"));
        for (Secretaria secretariaRegistrada : secService.findAll()) {
            if (secretariaRegistrada.getLogin().equals(login) && secretariaRegistrada.getSenha().equals(senha)) {
                secretaria = secretariaRegistrada;
                logado = true;
                return "consultas.xhtml?faces-redirect=true";
            }
        }
        MedicoService medService = new MedicoService(new ClinicaEntityManager("ClinicaPU"));
        for (Medico medicoRegistrado : medService.findAll()) {
            if (medicoRegistrado.getLogin().equals(login) && medicoRegistrado.getSenha().equals(senha)) {
                medico = medicoRegistrado;
                logado = true;
                return "consultas.xhtml?faces-redirect=true";
            }
        }
        AdministradorService admService = new AdministradorService(new ClinicaEntityManager("ClinicaPU"));
        for (Administrador administradorRegistrado : admService.findAll()) {
            if (administradorRegistrado.getLogin().equals(login) && administradorRegistrado.getSenha().equals(senha)) {
                administrador = administradorRegistrado;
                logado = true;
                return "dashboard.xhtml?faces-redirect=true";
            }
        }
        addMessage("Usuário e/ou Senha inválido(s)!"); //Retornar algo que não refresh a pag
        return "";
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public String sair() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login.xhtml?faces-redirect=true";
    }

    public boolean isAdmin() {
        return administrador != null;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Secretaria getSecretaria() {
        return secretaria;
    }

    public void setSecretaria(Secretaria secretaria) {
        this.secretaria = secretaria;
    }

    public Boolean getLogado() {
        return logado;
    }

    public void setLogado(Boolean logado) {
        this.logado = logado;
    }

}
