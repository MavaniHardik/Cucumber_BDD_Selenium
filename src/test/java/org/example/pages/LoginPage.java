package org.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    @FindBy(css=".page-title")
    public WebElement welcomeLoginText;

    public String getWelcomeTextOnLoginPage(){
        return welcomeLoginText.getText();

    }

}
