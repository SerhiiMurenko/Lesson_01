package org.example.uitests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTest {
    private WebDriver driver;

    private static final String USER_MAIL = "sermur@gmail.com";
    private static final String USER_INVALID_MAIL = "";

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("http://prestashop.qatestlab.com.ua/en/authentication?back=my-account#account-creation");
    }

    @Test
    public void createTestHappy() {
        WebElement userEmailField = driver.findElement(By.id("email_create"));
        userEmailField.clear();
        userEmailField.click();
        userEmailField.sendKeys(USER_MAIL);
        WebElement buttonCreate = driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]"));
        buttonCreate.click();
       // WebElement pageDataCreate = driver.findElement(By.xpath("//*[@id=\"authentication\"]"));
        WebElement e = driver.findElement(By.xpath("//*[text()='Create an account']"));
        //pageDataCreate.findElements(By.xpath("//*[@id=\"authentication\"]"));
        //pageDataCreate.findElements(By.xpath("//*[@id=\"account-creation_form\"]/div[1]/h3"));
        //WebElement chooseGender = pageDataCreate.findElement(By.id("//*[@id=\"uniform-id_gender1\"]"));
        //chooseGender.click();
    }


    @Test
    public void createTestUnHappy() {
        driver.getCurrentUrl();
        WebElement userEmailField = driver.findElement(By.id("email_create"));
        userEmailField.clear();
        userEmailField.click();
        userEmailField.sendKeys(USER_INVALID_MAIL);
        WebElement buttonCreate = driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]"));
        buttonCreate.click();
        driver.findElements(By.xpath("//*[@id=\"create_account_error\"]/ol/li"));
        driver.findElements(By.xpath("//*[text()='Invalid email address.']"));
//        invalid = driver.findElement(By.xpath("//*[@id=\"create-account_form\"]"));
//         invalid = driver.findElement(By.xpath("//*[@id=\"create_account_error\"]/ol/li"));

    }
}