/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetos.ci.clinica.controller;

import com.projetos.ci.clinica.entity.Medico;
import com.projetos.ci.clinica.entity.Paciente;
import com.projetos.ci.clinica.entity.Secretaria;
import com.projetos.ci.clinica.service.MedicoService;
import com.projetos.ci.clinica.service.PacienteService;
import com.projetos.ci.clinica.service.SecretariaService;
import com.projetos.ci.clinica.util.ClinicaEntityManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
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
//        listaTeste.add(new Paciente(1L, "Teste 1", "51515151"));
//        listaTeste.add(new Paciente(2L, "Aeste 1", "51515151"));
//        listaTeste.add(new Paciente(3L, "Oreste 1", "51515151"));
//        listaTeste.add(new Paciente(4L, "Moleque 1", "51515151"));
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

    public String redirecionaAnalises() {
        return "analises.xhtml?faces-redirect=true";
    }

    public String criarMedicos() {
        for (int i = 0; i < 10; i++) {
            int randomValue = new Random().nextInt(99999);
            Medico medTeste = new Medico();
            medTeste.setNome("Med " + randomValue);
            medTeste.setRg("1234" + randomValue);
            medTeste.setTelefone("(51) 444" + randomValue);
            medTeste.setCelular("(51) 444" + randomValue);
            medTeste.setEndereco("Av. Teste" + randomValue);
            medTeste.setLogin("med" + randomValue);
            medTeste.setSenha("med" + randomValue);
            medTeste.setTipoAcesso("3");
            medTeste.setStatus(true);
            medTeste.setEspecialidades("Psicologia" + randomValue);
            new MedicoService().save(medTeste);
        }
        return "dashboard.xhtml?faces-redirect=true";
    }

    public String criarPacientes() {
        for (int i = 0; i < 10; i++) {
            int randomValue = new Random().nextInt(99999);
            Paciente pacTeste = new Paciente();
            pacTeste.setNome("Pac " + randomValue);
            pacTeste.setTelefone("(51) 777" + randomValue);
            pacTeste.setEndereco("Av. Test" + randomValue);
            pacTeste.setDataNascimento(new Date());
            new PacienteService().save(pacTeste);
        }
        return "dashboard.xhtml?faces-redirect=true";
    }

    public String criarSecretarias() {
        for (int i = 0; i < 10; i++) {
            int randomValue = new Random().nextInt(99999);
            Secretaria secTeste = new Secretaria();
            secTeste.setNome("Sec " + randomValue);
            secTeste.setRg("1231" + randomValue);
            secTeste.setTelefone("(51) 777" + randomValue);
            secTeste.setCelular("(51) 777" + randomValue);
            secTeste.setEndereco("Av. Test" + randomValue);
            secTeste.setLogin("sec" + randomValue);
            secTeste.setSenha("sec" + randomValue);
            secTeste.setTipoAcesso("2");
            secTeste.setStatus(true);
            new SecretariaService().save(secTeste);
        }
        return "dashboard.xhtml?faces-redirect=true";
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
