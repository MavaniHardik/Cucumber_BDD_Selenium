package org.example.step_Defination;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.example.driver.DriverManager;
import org.example.pages.HomePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringEndsWith.endsWith;


public class HomeSteps extends DriverManager {
    DriverManager driverManager = new DriverManager();
    HomePage homePage = new HomePage();

    @Given("^I am on Homepage$")
    public void i_am_on_Homepage() throws Throwable {
       String myActualURl = driverManager.getCurrentURL();
        System.out.println(myActualURl);
        assertThat(myActualURl,is(endsWith("nopcommerce.com/")));

    }

    @When("^I click On login button$")
    public void i_click_On_login_button() throws Throwable {
        homePage.clickOnLoginButton();

    }
}
