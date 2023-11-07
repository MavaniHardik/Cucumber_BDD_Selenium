package org.example.step_Defination;

import cucumber.api.java.en.Then;
import org.example.driver.DriverManager;
import org.example.pages.LoginPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.core.Is.is;

public class LoginSteps extends DriverManager {
    DriverManager driverManager = new DriverManager();
    LoginPage loginPage = new LoginPage();
    @Then("^I should see\"([^\"]*)\" text on login page$")
    public void i_should_see_text_on_login_page(String expectedText) throws Throwable {
        System.out.println(expectedText);
        String myActualWelcomeText = loginPage.getWelcomeTextOnLoginPage();
        System.out.println(myActualWelcomeText);
        assertThat(myActualWelcomeText,is(equalToIgnoringCase(expectedText)));


    }

    @Then("^the URL should contain wiht \"([^\"]*)\"$")
    public void the_URL_should_contain_wiht(String expectedURLText) throws Throwable {
       String myActualCurrentURL = driverManager.getCurrentURL();
        System.out.println(myActualCurrentURL);

        assertThat(myActualCurrentURL,containsString(expectedURLText));
    }
}
