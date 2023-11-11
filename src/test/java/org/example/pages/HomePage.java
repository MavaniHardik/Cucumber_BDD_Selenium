package org.example.pages;

import org.example.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends DriverManager {
    DriverManager driverManager = new DriverManager();

    @FindBy(css = ".ico-login")
    public WebElement loginButton;

    public void clickOnLoginButton(){
      driverManager.waitForElementVisibility(loginButton,10,"Login button Not visible");
        loginButton.click();
    }


    }

