/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmatuella.clinic.pageobjects;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author Guilherme
 */
public class LoginPage {

    private final WebDriver localDriver;
    private WebElement loginInput;
    private WebElement passInput;
    private WebElement loginButton;

    public LoginPage() {
        localDriver = new FirefoxDriver();
        localDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public DashboardPage login() {
        localDriver.get("http://localhost:8080/javaee-clinic/faces/login.xhtml");
        
        loginInput = localDriver.findElement(By.xpath("//*[contains(@id,'login')]"));
        passInput = localDriver.findElement(By.xpath("//*[contains(@id,'pass')]"));
        loginButton = localDriver.findElement(By.xpath("//*[contains(@id,'loginButton')]"));

        loginInput.click();
        loginInput.sendKeys("admin");

        passInput.click();
        passInput.sendKeys("admin");

        loginButton.click();

        return new DashboardPage(this);
    }

    public WebDriver getLocalDriver() {
        return this.localDriver;
    }

}
