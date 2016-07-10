/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmatuella.clinic.converter;

import com.gmatuella.clinic.entity.Doctor;
import com.gmatuella.clinic.service.DoctorService;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Guilherme
 */
@FacesConverter("doctorConverter")
public class DoctorConverter implements javax.faces.convert.Converter {

    @Override
    public Object getAsObject(FacesContext ctx, UIComponent component,
            String value) {
        if (value != null && !value.isEmpty()) {
            return new DoctorService().findById(new Long(value));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o != null && o instanceof Doctor) {
            Doctor doctor = (Doctor) o;
            return String.valueOf(doctor.getId());
        }
        return "";
    }
}
