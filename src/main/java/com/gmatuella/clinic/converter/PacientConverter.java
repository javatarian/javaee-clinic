/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmatuella.clinic.converter;

import com.gmatuella.clinic.entity.Pacient;
import com.gmatuella.clinic.service.PacientService;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Guilherme
 */
@FacesConverter("pacientConverter")
public class PacientConverter implements javax.faces.convert.Converter {

    @Override
    public Object getAsObject(FacesContext ctx, UIComponent component,
            String value) {
        if (value != null && !value.isEmpty()) {
            return new PacientService().findById(new Long(value));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o != null && o instanceof Pacient) {
            Pacient pacient = (Pacient) o;
            return String.valueOf(pacient.getId());
        }
        return "";
    }
}
