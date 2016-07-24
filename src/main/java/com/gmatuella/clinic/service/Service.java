/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmatuella.clinic.service;

/**
 *
 * @author Guilherme
 */
public enum Service {
    
    SAVE ("save", "Calls a service to save an entity"),
    UPDATE ("update", "Calls a service to update an entity"),
    DELETE ("delete", "Calls a service to delete an entity"),
    FIND_BY_ID("findById", "Calls a service to find an entity by its ID");
    
    private final String value;
    private final String description;
    
    Service(String value, String description) {
        this.value = value;
        this.description = description;
    }
}
