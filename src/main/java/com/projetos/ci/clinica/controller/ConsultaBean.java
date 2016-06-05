/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetos.ci.clinica.controller;

import com.projetos.ci.clinica.entity.Consulta;
import com.projetos.ci.clinica.entity.Medico;
import com.projetos.ci.clinica.entity.Paciente;
import com.projetos.ci.clinica.service.ConsultaService;
import com.projetos.ci.clinica.util.ClinicaEntityManager;
import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author gmatuella
 */
@Named
@ViewScoped
public class ConsultaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Consulta> consultas;
    private List<Consulta> consultasRealizadas;
    private List<Consulta> consultasFiltradas;
    private Consulta consultaSelecionada;
    private Consulta consultaCadastrada;
    private ConsultaService service;
    private String testeString;

    @PostConstruct
    public void init() {
        this.consultaCadastrada = new Consulta();
        Paciente testeP = new Paciente(1L, "Roberto Car Loss", "(51) 23456781");
        Paciente testeP2 = new Paciente(2L, "Evil Edson Arantes of Birth", "(51) 32211451");
        Medico testeM = new Medico();
        testeM.setId(1L);
        testeM.setNome("Thomas Eddie Son");
        Medico testeM2 = new Medico();
        testeM2.setId(2L);
        testeM2.setNome("Mark Is Man");
//        Consulta testeC = new Consulta(1L, testeP, testeM, "Multimed", LocalDateTime.now());
//        Consulta testeC2 = new Consulta(2L, testeP2, testeM2, "IFGB", LocalDateTime.now());
        Consulta testeC = new Consulta(1L, testeP, testeM, "Multimed", new Date());
        Consulta testeC2 = new Consulta(2L, testeP2, testeM2, "IFGB", new Date());
        consultas = new ArrayList();
        consultas.add(testeC);
        consultas.add(testeC);
        consultas.add(testeC);
        consultas.add(testeC2);
        consultas.add(testeC);
        consultas.add(testeC2);
        consultas.add(testeC2);
        consultas.add(testeC);
        consultasRealizadas = new ArrayList();
        consultas.add(testeC2);
        consultas.add(testeC);
//        service = new ConsultaService(new ClinicaEntityManager("ClinicaPU"));
//        consultas = new ConsultaLazyDataModel(service.findAll());
    }

    public void cadastrarConsulta() {
//        consultaCadastrada.setDataConsulta(LocalDateTime.now());
        consultaCadastrada.setDataConsulta(new Date());
        consultaCadastrada.setId(3L);
        consultas.add(consultaCadastrada);
        this.consultaCadastrada = new Consulta();
        
        service = new ConsultaService(new ClinicaEntityManager("ClinicaPU"));
        service.save(consultaCadastrada);

        RequestContext requestContext = RequestContext.getCurrentInstance();

        requestContext.update(":form-cons");
        requestContext.execute("PF('dialogCadastroConsulta').hide()");
        addMessage("Consulta Cadastrada!");
    }

    public void deletarConsulta(){
        //Verificar se é 24 horas antes. Se for, deletar diretamente do banco.
    }

    public void editarConsulta(){
        
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

}
