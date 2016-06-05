/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetos.ci.clinica.converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Guilherme
 */
@FacesConverter("localDateTimeConverter")
public class LocalDateTimeConverter implements javax.faces.convert.Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return LocalDateTime.parse(value, DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        LocalDateTime dateValue = (LocalDateTime) value;
        return dateValue.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
    }

}
