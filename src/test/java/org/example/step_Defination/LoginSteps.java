package org.example.step_Defination;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.example.driver.DriverManager;
import org.example.pages.LoginPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.core.Is.is;

public class LoginSteps extends DriverManager {
    DriverManager driverManager = new DriverManager();
    LoginPage loginPage = new LoginPage();
    @Then("^I should see \"([^\"]*)\" text on login page$")
    public void i_should_see_text_on_login_page(String expectedText) throws Throwable {
        System.out.println(expectedText);
        String myActualWelcomeText = loginPage.getWelcomeTextOnLoginPage();
        System.out.println(myActualWelcomeText);
        assertThat(myActualWelcomeText,is(equalToIgnoringCase(expectedText)));


    }

    @Then("^the URL should contain with \"([^\"]*)\"$")
    public void the_URL_should_contain_wiht(String expectedURLText) throws Throwable {
       String myActualCurrentURL = driverManager.getCurrentURL();
        System.out.println(myActualCurrentURL);

        assertThat(myActualCurrentURL,containsString(expectedURLText));
    }

    @When("^I enter Valid Email \"([^\"]*)\" and Password \"([^\"]*)\"$")
    public void i_enter_Valid_Email_and_Password(String email, String password) throws Throwable {
        loginPage.enterEmailandPassword(email,password);
    }

    @When("^I click On login button on Login Page$")
    public void i_click_On_login_button_on_Login_Page() throws Throwable {
        loginPage.clickOnLoginButtonOnLoginPage();
    }

    @Then("^I Should see Logout button is displayed$")
    public void i_Should_see_Logout_button_is_displayed() throws Throwable {
        boolean isLogoutButtonDisplayed = loginPage.checkLogoutButtonIsDisplayed();
        assertThat(isLogoutButtonDisplayed, is(true));

    }

}
