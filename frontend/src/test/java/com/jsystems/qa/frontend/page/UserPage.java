package com.jsystems.qa.frontend.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPage extends BasePage {

    public UserPage (WebDriver driver){
        super (driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "masterbar__item-me-label")
    public WebElement userAvatar;
}
