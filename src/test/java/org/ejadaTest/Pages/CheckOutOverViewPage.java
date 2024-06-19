package org.ejadaTest.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutOverViewPage extends BasePage{
    public CheckOutOverViewPage(WebDriver driver) {
        super.setDriver(driver);
    }
    private final By checkOutOverViewPageHeader = By.xpath("//span[@data-test='title']");
    private final By totalBeforeTaxes = By.cssSelector(".summary_subtotal_label");
    private final By finishBtn = By.id("finish");

    public String assertCheckOutOverViewPage()  {
        return driver.findElement(checkOutOverViewPageHeader).getText();
    }
    public Double assertTotalBeforeTaxes() {
        return Double.parseDouble(driver.findElement(totalBeforeTaxes).getText().replace("Item total: $",""));
    }

    public boolean assertURL(){
        return driver.getCurrentUrl().equals("https://www.saucedemo.com/checkout-step-two.html");
    }

    public FinishPage clickFinishBtn() {
        driver.findElement(finishBtn).click();
        return new FinishPage(driver);
    }
}
