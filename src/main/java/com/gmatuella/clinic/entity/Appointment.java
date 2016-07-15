package com.gmatuella.clinic.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
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
@Table(name = "appointment")
public class Appointment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_pacient", referencedColumnName = "id", nullable = false)
    private Pacient pacient;

    @ManyToOne
    @JoinColumn(name = "id_doctor", referencedColumnName = "id", nullable = false)
    private Doctor doctor;

    @Column(name = "healthcare_plan", nullable = false)
    private String healthcarePlan;

    @Column(name = "appointment_date", nullable = false)
    private LocalDateTime appointmentDate;

    @Column(nullable = false)
    private Boolean status;

    @Column(nullable = true)
    private String observations;

    public Appointment() {

    }

    public Appointment(Long id, Pacient pacient, Doctor doctor, String healthcarePlan, LocalDateTime appointmentDate, Boolean status, String observations) {
        this.id = id;
        this.pacient = pacient;
        this.doctor = doctor;
        this.healthcarePlan = healthcarePlan;
        this.appointmentDate = appointmentDate;
        this.status = status;
        this.observations = observations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pacient getPacient() {
        return pacient;
    }

    public void setPacient(Pacient pacient) {
        this.pacient = pacient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getHealthcarePlan() {
        return healthcarePlan;
    }

    public void setHealthcarePlan(String healthcarePlan) {
        this.healthcarePlan = healthcarePlan;
    }

    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
        hash = 31 * hash + Objects.hashCode(this.pacient);
        hash = 31 * hash + Objects.hashCode(this.doctor);
        hash = 31 * hash + Objects.hashCode(this.healthcarePlan);
        hash = 31 * hash + Objects.hashCode(this.appointmentDate);
        hash = 31 * hash + Objects.hashCode(this.status);
        hash = 31 * hash + Objects.hashCode(this.observations);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Appointment other = (Appointment) obj;
        if (!Objects.equals(this.healthcarePlan, other.healthcarePlan)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.observations, other.observations)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.pacient, other.pacient)) {
            return false;
        }
        if (!Objects.equals(this.doctor, other.doctor)) {
            return false;
        }
        if (!Objects.equals(this.appointmentDate, other.appointmentDate)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Appointment{" + "id=" + id + ", pacient=" + pacient + ", doctor=" + doctor + ", healthcarePlan=" + healthcarePlan + ", appointmentDate=" + appointmentDate + ", status=" + status + ", observations=" + observations + '}';
    }
}
