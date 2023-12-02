package org.example.step_Defination;

import cucumber.api.java.en.Then;
import org.example.driver.DriverManager;
import org.example.pages.LogoutPage;

public class LogoutStep extends DriverManager {
    DriverManager driverManager = new DriverManager();
    LogoutPage logoutPage = new LogoutPage();

    @Then("^I click on Logout button$")
    public void i_click_on_Logout_button() throws Throwable {
        logoutPage.clickOnLogoutButton();

    }


}
