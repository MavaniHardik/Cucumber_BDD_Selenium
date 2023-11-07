package org.example;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.example.driver.DriverManager;

import java.sql.Driver;

public class Hooks {
    // we define all before and after method only once
    DriverManager driverManager = new DriverManager();
    @Before
    public void setUpMethod() throws IllegalAccessException {

        driverManager.runOnLocalBrowser();
        driverManager.maxBrowser();
        driverManager.openUrlMethod();
        driverManager.implicityWait();
    }

    @After
    public void tearDownMethod() throws InterruptedException {
        driverManager.sleepBrowser(5000);
        driverManager.closeBrowserMethod();

    }
}
