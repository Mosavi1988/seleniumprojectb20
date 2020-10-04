package com.cybertek.tests.day10_testbase_properties_driverUtil;

import com.cybertek.tests.utilities.BrowserUtils;
import com.cybertek.tests.utilities.SmartBearUtilities;
import com.cybertek.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBearPractices_9_10_11 {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        SmartBearUtilities.loginToSmartBear(driver);
    }

    @Test
    public void p9_delete_order_task(){
        // Locate the checkbox for 'Mark Smith' and click to it
        WebElement markSmithCheckbox = driver.findElement(By.xpath("//td[.='Mark Smith']/../td[1]"));
        BrowserUtils.wait(2);
        markSmithCheckbox.click();
        BrowserUtils.wait(1);
        // Locate "Delete selected' button and click on it
        WebElement deleteButton = driver.findElement(By.id("ctl00_MainContent_btnDelete"));
        deleteButton.click();

        // Assert 'Mark Smith' is not in the table
        List<WebElement> namesList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));

        for (WebElement each : namesList) {
            Assert.assertFalse(each.getText().equals("Mark Smith"));
        }
    }




}
