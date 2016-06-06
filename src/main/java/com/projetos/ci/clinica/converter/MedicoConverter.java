/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetos.ci.clinica.converter;

import com.projetos.ci.clinica.entity.Medico;
import com.projetos.ci.clinica.service.MedicoService;
import com.projetos.ci.clinica.util.ClinicaEntityManager;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Guilherme
 */
@FacesConverter("medicoConverter")
public class MedicoConverter implements javax.faces.convert.Converter {

    @Override
    public Object getAsObject(FacesContext ctx, UIComponent component,
            String value) {
        if (value != null && !value.isEmpty()) {
            return new MedicoService(new ClinicaEntityManager("ClinicaPU")).findMedico(new Long(value));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o instanceof Medico) {
            Medico medico = (Medico) o;
            if (medico != null && medico instanceof Medico && medico.getId() != null) {
                return String.valueOf(medico.getId());
            }
        }
        return "";
    }
}
