package org.ejadaTest.Pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    public static WebDriver driver;
    public void setDriver(WebDriver driver) {
        BasePage.driver = driver;
    }
}
