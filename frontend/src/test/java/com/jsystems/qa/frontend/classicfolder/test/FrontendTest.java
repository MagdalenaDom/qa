package com.jsystems.qa.frontend.classicfolder.test;

import com.jsystems.qa.frontend.Configuration;
import com.jsystems.qa.frontend.classicfolder.page.LoginPage;
import com.jsystems.qa.frontend.classicfolder.page.MainWordpressPage;
import com.jsystems.qa.frontend.classicfolder.page.UserPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FrontendTest extends Configfrontend {
    MainWordpressPage wordpressPage;
    LoginPage loginPage;
    UserPage userPage;

//    WebDriver driver;
//    @BeforeAll
//    public static void setUpAll(){
////        WebDriverManager.chromedriver().setup();
//    }

    @Test
    public void firstTest(){

//        System.setProperty("webdriver.chrome.driver", ClassLoader.getSystemClassLoader().getResource("driver/chromedriver.exe").getFile());
//        System.setProperty("webdriver.gecko.driver", ClassLoader.getSystemClassLoader().getResource("driver/geckodriver.exe").getFile());
//        System.setProperty("webdriver.gecko.driver", "D:/geckodriver.exe");
//        WebDriver driver = new FirefoxDriver();
//        driver.manage().window().maximize();
//        driver.manage().deleteAllCookies();
//        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
//
////        driver.get("https://wordpress.com/");
//        driver.get(Configuration.BASE_URL);

        wordpressPage = new MainWordpressPage(driver);
        assertTrue(wordpressPage.buildWebsite.isDisplayed());
        assertEquals(wordpressPage.buildWebsite.getText(), "Build a website,");

        assertTrue(wordpressPage.login.isDisplayed());
        assertEquals(wordpressPage.login.getText(), "Log In");
        wordpressPage.login.click();


//        try {
//            sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//    }


//        System.out.println(driver.toString());
//        WebElement login = driver.findElement(By.cssSelector(".x-nav-item.x-nav-item--wide.x-nav-item--logged-in"
//                + " a.x-nav-link.x-link"));
//        WebElement buildWebsite = driver.findElement(By.cssSelector("#lpc-headline "
//                + ".lpc-headline-container.lp-headline-container h1 span:nth-child(1)"));

//        assertTrue(login.isDisplayed());
//        assertEquals(login.getText(), "Log In");
//        login.click();

//        driver.quit();
    }

    @Test
    public void loginTest(){
//        System.setProperty("webdriver.gecko.driver", "D:/geckodriver.exe");
//        WebDriver driver = new FirefoxDriver();
//        driver.manage().window().maximize();
//        driver.manage().deleteAllCookies();
//        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
//        driver.get(Configuration.BASE_URL);

        wordpressPage = new MainWordpressPage(driver);
        wordpressPage.waitForVisibilityOfElement(wordpressPage.login, 30);
        wordpressPage.login.click();
        loginPage = new LoginPage(driver);
        loginPage.waitForVisibilityOfElement(loginPage.emailInput, 30);
        loginPage.emailInput.clear();
        loginPage.emailInput.sendKeys(Configuration.LOGIN);
        loginPage.buttonContinue.click();
        loginPage.waitForVisibilityOfElement(loginPage.password, 30);
        loginPage.password.clear();
        loginPage.password.sendKeys(Configuration.PASSWORD);
        loginPage.buttonContinue.click();


        userPage = new UserPage(driver);
        userPage.waitForVisibilityOfElement(userPage.userAvatar, 30);
        assertTrue(userPage.userAvatar.isDisplayed());

//        driver.quit();
    }

    @Test
    public void loginActionTest(){
//        System.setProperty("webdriver.gecko.driver", "D:/geckodriver.exe");
//        WebDriver driver = new FirefoxDriver();
//        driver.manage().window().maximize();
//        driver.manage().deleteAllCookies();
//        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
//        driver.get(Configuration.BASE_URL);
//

        wordpressPage = new MainWordpressPage(driver);
        wordpressPage.waitForVisibilityOfElement(wordpressPage.login, 30);
        wordpressPage.login.click();
        loginPage = new LoginPage(driver);
        loginPage.waitForVisibilityOfElement(loginPage.emailInput, 30);

        Actions action = new Actions(driver);
        action
                .moveToElement(loginPage.emailInput)
                .sendKeys(Configuration.LOGIN)
                .sendKeys(Keys.chord(Keys.ENTER))
                .build()
                .perform();

        loginPage.waitForVisibilityOfElement(loginPage.password, 30);
        assertTrue(loginPage.buttonContinue.getText().equals("Log In"));
    }


}
