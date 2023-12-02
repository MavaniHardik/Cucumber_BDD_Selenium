package org.example.pages;

import org.example.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends DriverManager {
    @FindBy(css = ".page-title")
    public WebElement welcomeLoginText;

    @FindBy(id = "Email")
    public WebElement emailInputField;

    @FindBy(id = "Password")
    public WebElement passwordInputField;

    @FindBy(css = ".login-button")
    public WebElement loingButtonOnLogin;

    @FindBy(css = ".ico-logout")
    public WebElement logOutButton;
    DriverManager driverManager = new DriverManager();


    public String getWelcomeTextOnLoginPage() throws InterruptedException {
        Thread.sleep(1000);
        return welcomeLoginText.getText();
    }

    public void enterEmailandPassword(String email,String password){
        emailInputField.clear();
        emailInputField.sendKeys(email);
        passwordInputField.clear();
        passwordInputField.sendKeys(password);
    }

    public void clickOnLoginButtonOnLoginPage() throws InterruptedException {
        loingButtonOnLogin.click();
        driverManager.sleepBrowser(3000);
    }

    public boolean checkLogoutButtonIsDisplayed() throws InterruptedException {
       return logOutButton.isDisplayed();

    }
}
