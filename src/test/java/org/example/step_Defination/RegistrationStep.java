package org.example.step_Defination;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.example.driver.DriverManager;
import org.example.pages.RegistrationPage;

import java.util.List;
import java.util.Map;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.junit.Assert.assertThat;

public class RegistrationStep extends DriverManager {
    List<Map<String, String>> data;
    RegistrationPage registrationPage = new RegistrationPage();

    @Given("^I am on the home page$")
    public void iAmOnTheHomePage() {

    }

        @When("^I click on the \"([^\"]*)\"$")
    public void i_click_on_the(String registrationButton) throws Throwable {
        registrationPage.clickonRegister();

    }

        @When("^I select gender \"([^\"]*)\"$")
        public void i_select_gender(String gender) throws Throwable {
            switch (gender) {
                case "Male":
                    registrationPage.selectMale();
                    break;
                case "Female":
                    registrationPage.selectFemale();
                    break;
                default:
                    throw new IllegalAccessException("Unexpected gender");
            }
        }

        @When("^I enter following details to register$")
        public void i_enter_following_details_to_register(DataTable dataTable) throws Throwable {
            data = dataTable.asMaps(String.class, String.class);
            System.out.println(data);
            registrationPage.enterRegistrationDetails(
                    data.get(0).get("firstName"),
                    data.get(0).get("lastName"),
                    data.get(0).get("email"),
                    data.get(0).get("password"),
                    data.get(0).get("confirmPassword")
            );

        }

        @When("^I click on the \"([^\"]*)\" on registration page$")
        public void i_click_on_the_on_registration_page(String regSubmitButton) throws Throwable {
            registrationPage.clickOnRegistrationButton();
        }

        @Then("^I should see \"([^\"]*)\" text on registration page$")
        public void i_should_see_text_on_registration_page(String expText) throws Throwable {
            String actualRegiSuccessText = registrationPage.getTextFromRegistrationResult();

        }
    }

