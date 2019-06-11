package com.jsystems.qa.frontend;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class frontendTest {

//    @BeforeAll
////    public static void setUpAll(){
////        System.setProperty("webdriver.gecko.driver", "D:/geckodriver.exe");
////    }

    @Test
    public void firstTest(){
        System.setProperty("webdriver.gecko.driver", "D:/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);

        driver.get("https://wordpress.com/");
//        try {
//            sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//    }

        WebElement login = driver.findElement(By.cssSelector(".x-nav-item.x-nav-item--wide.x-nav-item--logged-in" + "a.x-nav-link.x-link"));
        WebElement buildWebsite = driver.findElement(By.cssSelector("#lpc-headline " + ".lpc-headline-container.lp-headline-container h1 span:nth-child(1)"));

        assertTrue(login.isDisplayed());
        assertEquals(login.getText(), "Log In");
        login.click();

        driver.quit();
    }
}
