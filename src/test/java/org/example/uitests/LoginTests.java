package org.example.uitests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests {
    private WebDriver driver;

    private static final String USER_NAME = "tomsmith";
    private static final String USER_PASS = "SuperSecretPassword!";

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @Test
    public void loginTestWithXpath() {
        WebElement userNameField = driver.findElement(By.id("username"));
        WebElement userPasswordField = driver.findElement(By.id("password"));
        userNameField.clear();
        userNameField.sendKeys(USER_NAME);
        userPasswordField.clear();
        userPasswordField.sendKeys(USER_PASS);
        WebElement buttonLoggin = driver.findElement(By.xpath("//*[@id='login']/button/i"));
        buttonLoggin.click();


    }


    @AfterClass
    public void afterClass() {
        if (driver != null)
            driver.quit();
    }

}
