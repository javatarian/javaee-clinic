package com.projetos.ci.clinica.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author gmatuella
 */
@Entity
@Table(name = "consulta")
public class Consulta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_paciente", referencedColumnName = "id", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "id_medico", referencedColumnName = "id", nullable = false)
    private Medico medico;

    @Column(name = "plano_de_saude", length = 50, nullable = false)
    private String planoDeSaude;

    @Column(name = "data_consulta", nullable = false)
    private LocalDateTime dataConsulta;

    @Column(nullable = false)
    private Boolean compareceu;

    @Column(length = 1000, nullable = true)
    private String observacoes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public String getPlanoDeSaude() {
        return planoDeSaude;
    }

    public void setPlanoDeSaude(String planoDeSaude) {
        this.planoDeSaude = planoDeSaude;
    }

    public Boolean getCompareceu() {
        return compareceu;
    }

    public LocalDateTime getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDateTime dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public void setCompareceu(Boolean compareceu) {
        this.compareceu = compareceu;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Consulta() {

    }

    public Consulta(Long id, Paciente paciente, Medico medico, String planoDeSaude, LocalDateTime dataConsulta) {
        this.id = id;
        this.paciente = paciente;
        this.medico = medico;
        this.planoDeSaude = planoDeSaude;
        this.dataConsulta = dataConsulta;
    }
}
