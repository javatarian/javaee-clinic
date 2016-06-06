package com.projetos.ci.clinica.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_paciente", referencedColumnName = "id", nullable = false)
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.LAZY)
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

    public Consulta() {

    }

    public Consulta(Long id, Paciente paciente, Medico medico, String planoDeSaude, LocalDateTime dataConsulta, Boolean compareceu, String observacoes) {
        this.id = id;
        this.paciente = paciente;
        this.medico = medico;
        this.planoDeSaude = planoDeSaude;
        this.dataConsulta = dataConsulta;
        this.compareceu = compareceu;
        this.observacoes = observacoes;
    }

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.paciente);
        hash = 37 * hash + Objects.hashCode(this.medico);
        hash = 37 * hash + Objects.hashCode(this.planoDeSaude);
        hash = 37 * hash + Objects.hashCode(this.dataConsulta);
        hash = 37 * hash + Objects.hashCode(this.compareceu);
        hash = 37 * hash + Objects.hashCode(this.observacoes);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Consulta other = (Consulta) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.paciente, other.paciente)) {
            return false;
        }
        if (!Objects.equals(this.medico, other.medico)) {
            return false;
        }
        if (!Objects.equals(this.planoDeSaude, other.planoDeSaude)) {
            return false;
        }
        if (!Objects.equals(this.dataConsulta, other.dataConsulta)) {
            return false;
        }
        if (!Objects.equals(this.compareceu, other.compareceu)) {
            return false;
        }
        if (!Objects.equals(this.observacoes, other.observacoes)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Consulta{" + "id=" + id + ", pacienteId=" + paciente.getId() + ", medicoId=" + medico.getId() + ", planoDeSaude=" + planoDeSaude + ", dataConsulta=" + dataConsulta + ", compareceu=" + compareceu + ", observacoes=" + observacoes + '}';
    }
}
