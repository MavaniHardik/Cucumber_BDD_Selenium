package org.example.pages;

import org.example.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends DriverManager {
    DriverManager driverManager = new DriverManager();

@FindBy (className = "ico-register")
public WebElement clickOnRegister;
    @FindBy(id = "gender-male")
    public WebElement maleCheckBox;

    @FindBy(id = "gender-female")
    public WebElement femaleCheckBox;

    @FindBy(id = "register-button")
    public WebElement registrationButton;

    @FindBy(id = "FirstName")
    public WebElement firstNameInputBox;

    @FindBy(id = "LastName")
    public WebElement lastNameInputBox;

    @FindBy(id = "Email")
    public WebElement emailInputBox;

    @FindBy(id = "Password")
    public WebElement passwordInputBox;

    @FindBy(id = "ConfirmPassword")
    public WebElement confirmPasswordInputBox;

    @FindBy(css = "div[class='result']")
    public WebElement registrationSuccessText;

public void clickonRegister(){
    clickOnRegister.click();
}

    public void selectMale(){
        maleCheckBox.click();
    }

    public void selectFemale(){
        femaleCheckBox.click();
    }

    public void clickOnRegistrationButton() {
        registrationButton.click();
    }

    public String getTextFromRegistrationResult() {
        return registrationSuccessText.getText();
    }

    public void enterRegistrationDetails(String firstName, String lastName, String email, String password, String confirmPassword) throws InterruptedException {
        firstNameInputBox.clear();
        firstNameInputBox.sendKeys(firstName);
        lastNameInputBox.clear();
        lastNameInputBox.sendKeys(lastName);
        emailInputBox.clear();
        int myRandomNumber = driverManager.generateRandomNumber();
        emailInputBox.sendKeys(myRandomNumber+email);
        passwordInputBox.clear();
        passwordInputBox.sendKeys(password);
        confirmPasswordInputBox.clear();
        confirmPasswordInputBox.sendKeys(confirmPassword);
        driverManager.sleepBrowser(4000);
    }

    public void clickOnRegistraionButton(){
        registrationButton.click();

    }


}
