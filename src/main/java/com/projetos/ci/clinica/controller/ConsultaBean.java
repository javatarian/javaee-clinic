/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetos.ci.clinica.controller;

import com.projetos.ci.clinica.entity.Consulta;
import com.projetos.ci.clinica.service.ConsultaService;
import com.projetos.ci.clinica.util.ClinicaEntityManager;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
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
public class ConsultaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Consulta consultaSelecionada, consultaCadastrada;
    private List<Consulta> consultas, consultasRealizadas, consultasFiltradas;
    private String testeString;
    private LocalDateTime testeldt;

    @PostConstruct
    public void init() {
        consultaCadastrada = new Consulta();
        consultaSelecionada = new Consulta();
        consultas = new ConsultaService(new ClinicaEntityManager("ClinicaPU")).findAll();
    }

    public void cadastrarConsulta() {
        System.out.println(consultaCadastrada);
        consultaCadastrada.setCompareceu(Boolean.FALSE);
        new ConsultaService(new ClinicaEntityManager("ClinicaPU")).save(consultaCadastrada);
        consultas = new ConsultaService(new ClinicaEntityManager("ClinicaPU")).findAll();
        consultaCadastrada = new Consulta();

        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.execute("PF('dialogCadastroConsulta').hide()");
        addMessage("Consulta cadastrada com sucesso!");
    }

    public void deletarConsulta() {
        //Verificar se é 24 horas antes. Se for, deletar diretamente do banco.
    }

    public void editarConsulta() {

    }

    public void abrirConsulta(Consulta consulta) {
//        long diferencaDeTempo = Duration.between(consulta.getDataConsulta(), LocalDateTime.now()).getSeconds();
        long diferencaDeTempo = 1000L;
        if (diferencaDeTempo < 1800) {
            RequestContext requestContext = RequestContext.getCurrentInstance();
            requestContext.execute("PF('dialogAbreConsulta').show()");
        } else {
            addMessage("Não é possível abrir a consulta fora do horário determinado!");
        }
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void onRowSelect(SelectEvent event) {
    }

    public Consulta getConsultaSelecionada() {
        return consultaSelecionada;
    }

    public void setConsultaSelecionada(Consulta consultaSelecionada) {
        this.consultaSelecionada = consultaSelecionada;
    }

    public Collection<Consulta> getConsultas() {
        return consultas;
    }

    public Consulta getConsultaCadastrada() {
        return consultaCadastrada;
    }

    public void setConsultaCadastrada(Consulta consultaCadastrada) {
        this.consultaCadastrada = consultaCadastrada;
    }

    public String getTesteString() {
        return testeString;
    }

    public void setTesteString(String testeString) {
        this.testeString = testeString;
    }

    public List<Consulta> getConsultasFiltradas() {
        return consultasFiltradas;
    }

    public void setConsultasFiltradas(List<Consulta> consultasFiltradas) {
        this.consultasFiltradas = consultasFiltradas;
    }

    public List<Consulta> getConsultasRealizadas() {
        return consultasRealizadas;
    }

    public void setConsultasRealizadas(List<Consulta> consultasRealizadas) {
        this.consultasRealizadas = consultasRealizadas;
    }

    public LocalDateTime getTesteldt() {
        return testeldt;
    }

    public void setTesteldt(LocalDateTime testeldt) {
        this.testeldt = testeldt;
    }
}
