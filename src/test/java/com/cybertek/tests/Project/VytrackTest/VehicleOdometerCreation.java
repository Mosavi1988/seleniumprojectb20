package com.cybertek.tests.Project.VytrackTest;

import com.cybertek.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class VehicleOdometerCreation {


    WebDriver driver;
    @BeforeTest
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        // Go to https://qa2.vytrack.com/user/login
        driver.get("https://qa2.vytrack.com/user/login");
    }

    @Test(priority = 1)
    public void loginVerification()throws InterruptedException{
        Thread.sleep(1500);
        WebElement userName = driver.findElement(By.xpath("//input[@name='_username']"));
        userName.sendKeys("user169");
        WebElement password = driver.findElement(By.xpath("//input[@name='_password']"));
        password.sendKeys("UserUser123");
        WebElement loginButton = driver.findElement(By.xpath("//button[@name='_submit']"));
        loginButton.click();
    }

    @Test(priority = 2)
    public void fleetAndOdometer()throws InterruptedException{
        Thread.sleep(2000);
        driver.findElement(By.linkText("Fleet")).click();

        Thread.sleep(2000);
        WebElement odometer = driver.findElement(By.linkText("Vehicle Odometer"));
        odometer.click();
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    public void createOdometer()throws InterruptedException{
        Thread.sleep(2000);
        WebElement createVehicleOdometer = driver.findElement(By.linkText("Create Vehicle Odometer"));
        createVehicleOdometer.click();
        WebElement odometerValueInput = driver.findElement(By.name("custom_entity_type[OdometerValue]"));
        Thread.sleep(2000);
        odometerValueInput.sendKeys("200");
        WebElement dateInput = driver.findElement(By.xpath("//input[@placeholder='Choose a date']"));
        dateInput.sendKeys("Oct 5, 2020"+ Keys.TAB);

        WebElement driverInput = driver.findElement(By.name("custom_entity_type[Driver]"));
        Thread.sleep(2000);
        driverInput.sendKeys("David");

        WebElement addButton = driver.findElement(By.xpath("//button[@class='btn btn-medium add-btn']"));
        addButton.click();

        WebElement licensePlateSelection = driver.findElement(By.xpath("//td[.='9777']"));
        licensePlateSelection.click();

        WebElement selectOption = driver.findElement(By.xpath("//button[.='Select']"));
        selectOption.click();

        WebElement saveAndClose = driver.findElement(By.xpath("//button[@class='btn btn-success action-button']"));
        saveAndClose.click();
        Thread.sleep(3000);

        String expectedResult = "200";
        String actualresult = driver.findElement(By.xpath("//div[@class='control-label']")).getText();

        Assert.assertEquals(expectedResult,actualresult);

        driver.close();

    }




}

