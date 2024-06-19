package org.ejadaTest.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.ejadaTest.Pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;

public class OrderCycleSD {
    public WebDriver driver;
    private LoginSD login;
    private HomePage homePage;
    private CartPage cartPage;
    private CheckOutPage checkOutPage;
    private CheckOutOverViewPage checkOutOverViewPage;
    private FinishPage finishPage;

    List<String> SelectedItems;
    private double totalPrice;

    public OrderCycleSD() {
    }

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        login = new LoginSD();
        login.iAmOnTheLoginPage("chrome");
        login.iEnterMyUsernameAndPassword("standard_user","secret_sauce");
    }

    @And("I logged in to Homepage")
    public void iLoggedInToHomepage() {
        homePage = login.iPressTheLoginButton2();
        Assert.assertEquals(homePage.iAmOnTheHomePage(),"Products");
    }

    @And("I add the highest price 2 products to cart")
    public void iAddTheHighestPriceProductsToCart() {
        SelectedItems = homePage.iAddTheHighestPriceProductsToCart();
        cartPage = homePage.moverTheCart();
    }

    @And("I validate the order is correctly at the cart")
    public void iValidateTheOrderIsCorrectlyAtTheCart() {
        Assert.assertEquals(cartPage.iAmOnTheCartPage(),"Your Cart");
        Assert.assertEquals(cartPage.getCartItems(),SelectedItems);
        totalPrice = cartPage.getTotalPrice();
    }

    @And("I click on the Proceed to checkout button")
    public void iClickOnTheButton() {
        checkOutPage = cartPage.getCheckOutPage();
        Assert.assertEquals(checkOutPage.assertCheckOutPage(),"Checkout: Your Information");
    }

    @And("I fill requested info at the checkout page")
    public void iFillRequestedInfoAtTheCheckoutPage() {
        checkOutPage.fillRequestedInfo();

    }

    @And("I click on the Proceed to checkout overview button")
    public void iClickOnTheProceedToCheckoutOverviewButton() {
        checkOutOverViewPage = checkOutPage.moveToOverViewPage();
        Assert.assertEquals(checkOutOverViewPage.assertCheckOutOverViewPage(),"Checkout: Overview");
    }

    @And("I validate the order is correctly at the checkout overview page")
    public void iValidateTheOrderIsCorrectlyAtTheCheckoutOverviewPage() {
        Assert.assertTrue(checkOutOverViewPage.assertURL());
        Assert.assertEquals(checkOutOverViewPage.assertTotalBeforeTaxes(),totalPrice);
    }

    @And("I click on the Proceed to finish button")
    public void iClickOnTheProceedToFinishButton() {
        finishPage = checkOutOverViewPage.clickFinishBtn();
    }

    @Then("I can validate the order")
    public void iCanValidateTheOrder() {
        Assert.assertEquals(finishPage.assertFinishPage(),"Checkout: Complete!");
        Assert.assertTrue(finishPage.isFinishedTitle().contains("Thank you"));
        Assert.assertTrue(finishPage.isFinishedText().contains("Your order has been dispatched"));
        finishPage.quit();
    }
}
