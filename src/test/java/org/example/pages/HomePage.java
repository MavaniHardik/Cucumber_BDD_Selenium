package org.example.pages;

import org.example.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends DriverManager {
    @FindBy(css = ".ico-login")
    public WebElement loginButton;

    public void clickOnLoginButton(){
        loginButton.click();
    }


    }

