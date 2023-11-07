package org.example.pages;

import org.example.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends DriverManager {
    @FindBy(xpath="/html/body/div[6]/div[3]/div/div/div/div[1]/h1")
    private WebElement welcomeLoginText;

    public String getWelcomeTextOnLoginPage() throws InterruptedException {
        Thread.sleep(3000);
        return welcomeLoginText.getText();

    }

}
