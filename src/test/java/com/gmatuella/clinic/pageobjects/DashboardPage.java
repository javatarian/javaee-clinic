/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmatuella.clinic.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 *
 * @author Guilherme
 */
public class DashboardPage {

    private final LoginPage loginPage;

    public DashboardPage(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    public boolean getLoggedAdmin() {
        WebElement analyticsTab = loginPage.getLocalDriver().findElement(By.xpath("//*[contains(@id,'analytics')]"));
        System.out.println(analyticsTab.isDisplayed());
        return true;
    }
}
