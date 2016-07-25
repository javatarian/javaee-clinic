/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmatuella.clinic.pageobjects.tests;

import com.gmatuella.clinic.pageobjects.DashboardPage;
import com.gmatuella.clinic.pageobjects.LoginPage;
import static org.testng.Assert.*;

/**
 *
 * @author Guilherme
 */
public class LoginTest {

    private LoginPage firstPage;

    public void setUp() {
        firstPage = new LoginPage();
    }

    public void testHasAdminLoggedIn() {
        DashboardPage dashboard = firstPage.login();
        assertEquals("?", dashboard.getLoggedUserName());
    }

    public void tearDown() {
        firstPage.getLocalDriver().close();
    }
}
