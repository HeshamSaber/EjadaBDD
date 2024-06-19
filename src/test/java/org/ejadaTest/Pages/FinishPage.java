package org.ejadaTest.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FinishPage extends BasePage {
    public FinishPage(WebDriver driver) {
        super.setDriver(driver);
    }
    private final By FinishPageHeader = By.xpath("//span[@data-test='title']");
    private final By FinishTitle = By.cssSelector(".complete-header");
    private final By FinishText = By.cssSelector(".complete-text");

    public String assertFinishPage(){
        return driver.findElement(FinishPageHeader).getText();
    }
    public String isFinishedTitle() {
        return driver.findElement(FinishTitle).getText();
    }
    public String isFinishedText() {
        return driver.findElement(FinishText).getText();
    }

    public void quit() {
        driver.quit();
    }
}
