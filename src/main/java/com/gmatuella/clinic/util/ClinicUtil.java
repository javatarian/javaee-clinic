/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmatuella.clinic.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Guilherme
 */
//Singleton with lazy initialization and is thread safe.
public class ClinicUtil {

    private static ClinicUtil instance;

    public static synchronized ClinicUtil getInstance() {
        if (instance == null) {
            instance = new ClinicUtil();
        }
        return instance;
    }

    public void addMessage(String text) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, text, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void executeOnContext(String textToExecute) {
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute(textToExecute);
    }
}
