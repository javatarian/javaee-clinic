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

    SAVE("SAVE", "Entity save service"),
    UPDATE("UPDATE", "Entity update service"),
    DELETE("DELETE", "Entity delete service");

    private final String value;
    private final String description;

    Service(String value, String description) {
        this.value = value;
        this.description = description;
    }

    public String getValue() {
        return this.value;
    }

    public String getDescription() {
        return this.description;
    }
}
