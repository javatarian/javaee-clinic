/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmatuella.clinic.entity;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author gmatuella
 */
@Entity
@Table(name = "secretary")
public class Secretary extends User implements Serializable {

    public Secretary() {
    }

    public Secretary(Long id, String name, String phone, String address, LocalDate birthDate, String login, String password, Boolean status) {
        super(id, name, phone, address, birthDate, login, password, status);
    }

}
