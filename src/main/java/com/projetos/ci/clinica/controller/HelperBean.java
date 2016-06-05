/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetos.ci.clinica.controller;

import com.projetos.ci.clinica.entity.Paciente;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import org.primefaces.context.RequestContext;

/**
 *
 * @author gmatuella
 */
@Named
@RequestScoped
public class HelperBean {

    public HelperBean() {
    }

    public List<String> completeText(String query) {
        List<String> results = new ArrayList();
//        PacienteService service = new PacienteService(new ClinicaEntityManager("ClinicaPU"));
//        for (Paciente p : service.findAll()) {
//            if((p.getNome().toLowerCase()).contains(query.toLowerCase())){
//                results.add(p.getNome());
//            }
//        }
        List<Paciente> listaTeste = new ArrayList();
        listaTeste.add(new Paciente(1L, "Teste 1", "51515151"));
        listaTeste.add(new Paciente(2L, "Aeste 1", "51515151"));
        listaTeste.add(new Paciente(3L, "Oreste 1", "51515151"));
        listaTeste.add(new Paciente(4L, "Moleque 1", "51515151"));
        for (Paciente p : listaTeste) {
            if ((p.getNome().toLowerCase()).contains(query.toLowerCase())) {
                results.add(p.getNome());
            }
        }
        if (results.isEmpty()) {
            results.add("Paciente não encontrado!");
        }
        return results;
    }

    public String redirecionaLogin() {
        return "login.xhtml?faces-redirect=true";
    }

    public String redirecionaDashboard() {
        return "dashboard.xhtml?faces-redirect=true";
    }

    public String redirecionaConsultas() {
        return "consultas.xhtml?faces-redirect=true";
    }

    public void buttonAction(ActionEvent actionEvent) {
        addMessage("Paciente cadastrado com sucesso!");
    }

    public void buttonAction2(ActionEvent actionEvent) {
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dialogCadastroFuncionario').hide();");
        addMessage("Funcionário cadastrado com sucesso!");
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
