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
import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author gmatuella
 */
@ManagedBean(eager = true)
@RequestScoped
public class ApplicationInitializer {

    public ApplicationInitializer() {
        for (int i = 0; i < 10; i++) {
            Medico medTeste = new Medico();
            medTeste.setNome("Medteste " + i);
            medTeste.setRg("12345678" + i);
            medTeste.setTelefone("(51) 4444-555" + i);
            medTeste.setCelular("(51) 4444-556" + i);
            medTeste.setEndereco("Av. Teste" + i);
            medTeste.setLogin("med" + i);
            medTeste.setSenha("med" + i);
            medTeste.setTipoAcesso("3");
            medTeste.setEspecialidades("Psicologia" + i);
            new MedicoService(new ClinicaEntityManager("ClinicaPU")).save(medTeste);
        }
        
        for (int i = 0; i < 10; i++) {
            Secretaria secTeste = new Secretaria();
            secTeste.setNome("Secteste " + i);
            secTeste.setRg("12312311" + i);
            secTeste.setTelefone("(51) 7777-555" + i);
            secTeste.setCelular("(51) 7777-556" + i);
            secTeste.setEndereco("Av. Test" + i);
            secTeste.setLogin("sec" + i);
            secTeste.setSenha("sec" + i);
            secTeste.setTipoAcesso("2");
            new SecretariaService(new ClinicaEntityManager("ClinicaPU")).save(secTeste);
        }
        
        for (int i = 0; i < 10; i++) {
            Paciente pacTeste = new Paciente();
            pacTeste.setNome("Secteste " + i);
            pacTeste.setTelefone("(51) 7777-555" + i);
            pacTeste.setEndereco("Av. Test" + i);
            pacTeste.setDataNascimento(new Date());
            new PacienteService(new ClinicaEntityManager("ClinicaPU")).save(pacTeste);
        }
    }
}
