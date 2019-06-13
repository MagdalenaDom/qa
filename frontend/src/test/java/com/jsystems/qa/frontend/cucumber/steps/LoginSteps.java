package com.jsystems.qa.frontend.cucumber.steps;

import com.jsystems.qa.frontend.Configuration;
import com.jsystems.qa.frontend.cucumber.CucumberStepConfig;
import com.jsystems.qa.frontend.cucumber.page.*;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import cucumber.api.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps{

    WebDriver driver;
    MainWordpressPage wordpressPage;
    LoginPage loginPage;
    UserPage userPage;
    UserProfilePage userProfilePage;
    Notification notification;

    public LoginSteps(CucumberStepConfig stepConfig){

        driver = stepConfig.setUp();
    }

    @Given("^User start on main page$")
    public void userStartOnMainPage() {
        driver.get(Configuration.BASE_URL);
        loginTest();


        userPage = new UserPage(driver);
        userPage.waitForVisibilityOfElement(userPage.userAvatar, 30);
        assertTrue(userPage.userAvatar.isDisplayed());
        
    }

    @When("^User log in to the user page$")
    public void userLogInToTheUserPage() {
        loginTest();
        
    }

    @Then("^User can modified user profile$")
    public void userCanModifiedUserProfile() {
        userPage.userAvatar.click();
        userProfilePage = new UserProfilePage(driver);
        userProfilePage.waitForVisibilityOfElement(userProfilePage.buttonSave, 120);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", userProfilePage.buttonSave);

        userProfilePage.waitForVisibilityOfElement(userProfilePage.buttonSave, 120);
        assertFalse(userProfilePage.buttonSave.isEnabled());
    }

    @Given("^User start on page \"([^\"]*)\"$")
    public void userStartOnPage(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        driver.get(arg0);
    }

    @Then("^User can modified notifications$")
    public void userCanModifiedNotifications() {
        userPage = new UserPage(driver);
        userPage.waitForVisibilityOfElement(userPage.userAvatar, 120);
        userPage.userAvatar.click();
        userProfilePage = new UserProfilePage(driver);
        userProfilePage.waitForVisibilityOfElement(userProfilePage.buttonSave, 120);
        userProfilePage.waitForVisibilityOfElement(userProfilePage.notification, 120);
        userProfilePage.notification.click();
        notification = new Notification(driver);
        notification.waitForVisibilityOfElement(notification.firstCheckbox, 120);
        assertTrue(notification.firstCheckbox.isSelected());
    }


    public void loginTest(){
        wordpressPage = new MainWordpressPage(driver);
        wordpressPage.waitForVisibilityOfElement(wordpressPage.login, 120);
        wordpressPage.login.click();
        loginPage = new LoginPage(driver);
        loginPage.waitForVisibilityOfElement(loginPage.emailInput, 120);
        loginPage.emailInput.clear();
        loginPage.emailInput.sendKeys(Configuration.LOGIN);
        loginPage.buttonContinue.click();
        loginPage.waitForVisibilityOfElement(loginPage.password, 120);
        loginPage.password.clear();
        loginPage.password.sendKeys(Configuration.PASSWORD);
        loginPage.buttonContinue.click();
    }


}
