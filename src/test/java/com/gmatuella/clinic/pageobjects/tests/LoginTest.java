/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmatuella.clinic.pageobjects.tests;

import com.gmatuella.clinic.pageobjects.DashboardPage;
import com.gmatuella.clinic.pageobjects.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 *
 * @author Guilherme
 */
public class LoginTest {

    private LoginPage firstPage;

    @BeforeMethod
    public void setUp() {
        firstPage = new LoginPage();
    }


    public void testHasAdminLoggedIn() {
        DashboardPage dashboard = firstPage.login();
        
        assertTrue(dashboard.getLoggedAdmin(), "Testing if the admin has logged in by "
                + "verifying if the analytics tab is displayed.");
    }

    @AfterMethod
    public void tearDown() {
        firstPage.getLocalDriver().close();
    }
}
