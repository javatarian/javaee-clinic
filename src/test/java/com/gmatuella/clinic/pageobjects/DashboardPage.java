/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmatuella.clinic.pageobjects;

import org.openqa.selenium.By;

/**
 *
 * @author Guilherme
 */
public class DashboardPage {

    private final LoginPage loginPage;

    public DashboardPage(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    public String getLoggedUserName() {
        return loginPage.getLocalDriver().findElement(By.id("?")).getAttribute("?");
    }
}
