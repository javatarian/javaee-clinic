/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetos.ci.clinica.converter;

import com.projetos.ci.clinica.entity.Paciente;
import com.projetos.ci.clinica.service.MedicoService;
import com.projetos.ci.clinica.service.PacienteService;
import com.projetos.ci.clinica.util.ClinicaEntityManager;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Guilherme
 */
@FacesConverter("pacienteConverter")
public class PacienteConverter implements javax.faces.convert.Converter {

    @Override
    public Object getAsObject(FacesContext ctx, UIComponent component,
            String value) {
        if (value != null && !value.isEmpty()) {
            return new PacienteService(new ClinicaEntityManager("ClinicaPU")).findPaciente(new Long(value));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o instanceof Paciente) {
            Paciente paciente = (Paciente) o;
            if (paciente != null && paciente instanceof Paciente && paciente.getId() != null) {
                return String.valueOf(paciente.getId());
            }
        }
        return "";
    }
}
