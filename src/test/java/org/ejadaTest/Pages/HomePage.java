package org.ejadaTest.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super.setDriver(driver);
    }
    private final By productsPageHeader = By.xpath("//span[@data-test='title']");
    private final By productsList = By.cssSelector(".inventory_item");
    private final By price = By.className("inventory_item_price");
    private final By addToCartBtn = By.className("btn_inventory");
    private final By moveToCartBtn = By.xpath("//a[@data-test='shopping-cart-link']");
    private final By itemName = By.className("inventory_item_name");
    private final List<String> Items = new ArrayList<>();

    public String iAmOnTheHomePage() {
        return driver.findElement(productsPageHeader).getText();
    }

    public List<String> iAddTheHighestPriceProductsToCart() {
        System.out.println("addToCart");
        List<WebElement> products = driver.findElements(productsList);
        System.out.println(products);
        products.sort((p1, p2) -> {
            double price1 = Double.parseDouble(p1.findElement(price).getText().replace("$", ""));
            double price2 = Double.parseDouble(p2.findElement(price).getText().replace("$", ""));
            return Double.compare(price2, price1);
        });

        for (int i = 0; i < 2; i++) {
            WebElement addToCartButton = products.get(i).findElement(addToCartBtn);
            addToCartButton.click();
            Items.add(products.get(i).findElement(itemName).getText());
        }
        return Items;
    }
    public CartPage moverTheCart() {
        driver.findElement(moveToCartBtn).click();
        return new CartPage(driver);
    }
}
