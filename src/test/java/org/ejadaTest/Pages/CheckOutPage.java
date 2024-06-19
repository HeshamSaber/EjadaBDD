package org.ejadaTest.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage extends BasePage {
    public CheckOutPage(WebDriver driver) {
        super.setDriver(driver);
    }
    private final By checkOutPageHeader = By.xpath("//span[@data-test='title']");
    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By postalCode = By.id("postal-code");
    private final By continueBtn = By.id("continue");

    public String assertCheckOutPage() {
        return driver.findElement(checkOutPageHeader).getText();
    }

    public void fillRequestedInfo() {
        driver.findElement(firstName).sendKeys("firstName");
        driver.findElement(lastName).sendKeys("lastName");
        driver.findElement(postalCode).sendKeys("postalCode");
    }

    public CheckOutOverViewPage moveToOverViewPage() {
        driver.findElement(continueBtn).click();
        return new CheckOutOverViewPage(driver);
    }
}
