package org.ejadaTest.stepDefinitions;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.ejadaTest.Pages.BasePage;
import org.ejadaTest.Pages.HomePage;
import org.ejadaTest.Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class LoginSD {

    public WebDriver driver;
    private final BasePage basePage;
    private LoginPage loginPage;

    public LoginSD() {
        basePage = new BasePage();
    }

    @Given("I am on the login page on browser {string}")
    public void iAmOnTheLoginPage(String browser) {
        if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.get("https://www.saucedemo.com/");
            System.out.println("I am on the login page");
        } else if (browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
            driver.get("https://www.saucedemo.com/");
            System.out.println("I am on the login page");
        }
        basePage.setDriver(driver);
        System.out.println("I am on the login page");
    }

    @When("I enter my username {string} and password {string}")
    public void iEnterMyUsernameAndPassword(String username, String password) {
        loginPage = new LoginPage();
        loginPage.enterUserName(username);
        loginPage.enterPassword(password);
        System.out.println("I enter my username : " + username + " and password : " + password);
    }

    @And("^I press the login button$")
    public void iPressTheLoginButton() {
        loginPage.clickLoginButton();
        System.out.println("I press the login button");
    }

    public HomePage iPressTheLoginButton2() {
        loginPage.clickLoginButton();
        return new HomePage(driver);
    }


    @Then("I should see an errormessage {string}")
    public void iShouldSeeAnErrormessage(String error) {
        String actualMessage = loginPage.getErrorMessage();
        System.out.println("Actual error message : " + actualMessage);
        System.out.println("I should see an error message : " + error);
        Assert.assertEquals(actualMessage, error);
        driver.quit();
    }
}
