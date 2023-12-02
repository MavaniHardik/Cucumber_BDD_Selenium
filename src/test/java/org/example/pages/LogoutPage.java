package org.example.pages;

import org.example.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends DriverManager {

    @FindBy (css = ".ico-logout")
    public WebElement logoutbutton ;


    public void clickOnLogoutButton () throws InterruptedException {
        sleepBrowser(2000);
        logoutbutton.click();

    }
}
