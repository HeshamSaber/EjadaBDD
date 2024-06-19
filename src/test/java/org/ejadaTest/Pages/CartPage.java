package org.ejadaTest.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super.setDriver(driver);
    }
    private final By cartPageHeader = By.xpath("//span[@data-test='title']");
    private final By productsList = By.cssSelector(".cart_item");
    private final By itemName = By.className("inventory_item_name");
    private final By price = By.className("inventory_item_price");
    private final List<String> cartItems = new ArrayList<>();
    private final By checkoutButton = By.id("checkout");
    private double totalPrice = 0;

    public String iAmOnTheCartPage() {
        return driver.findElement(cartPageHeader).getText();
    }

    public List<String> getCartItems(){
        List<WebElement> products = driver.findElements(productsList);
        for (int i = 0; i < 2; i++) {
            cartItems.add(products.get(i).findElement(itemName).getText());
            totalPrice += Double.parseDouble(products.get(i).findElement(price).getText().replace("$", ""));
        }
        return cartItems;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public CheckOutPage getCheckOutPage(){
        driver.findElement(checkoutButton).click();
        return new CheckOutPage(driver);
    }

}
