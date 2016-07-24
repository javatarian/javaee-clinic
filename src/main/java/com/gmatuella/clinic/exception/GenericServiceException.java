/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmatuella.clinic.exception;

import com.gmatuella.clinic.service.Service;

/**
 *
 * @author Guilherme
 */
public class GenericServiceException extends Exception {

    private String errorMessage;
    private final String serviceMessage;

    public GenericServiceException(String errorMessage, Service service) {
        super(errorMessage);
        this.serviceMessage = serviceMessageGenerator(service);
    }

    private String serviceMessageGenerator(Service service) {
        return "The system found an error at " + service.getDescription() + ".";
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getServiceMessage() {
        return serviceMessage;
    }
}
