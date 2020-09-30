package com.cybertek.tests.day9_windows_tabs;

import com.cybertek.tests.utilities.BrowserUtils;
import com.cybertek.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandlingPractice {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/windows");
    }

    @Test
    public void p5_Handling_Widnows(){

        String actualTitle = driver.getTitle();
        System.out.println("actualTitle = " + actualTitle);

        Assert.assertTrue(actualTitle.equals("Practice"));

        WebElement clickHereLink = driver.findElement(By.linkText("Click Here"));
        clickHereLink.click();

        String titleAfterClick = driver.getTitle();
        System.out.println("titleAfterClick = " + titleAfterClick);

        String mainHandle = driver.getWindowHandle();
        System.out.println("mainHandle = " + mainHandle);

        //set allows only unique values.
        Set<String> windowHandles = driver.getWindowHandles();

        for (String each : windowHandles) {
            driver.switchTo().window(each);
            System.out.println("Current title= "+ driver.getTitle());
        }

        // Getting the current(actual) title, and comparing with expected title.
        Assert.assertTrue(driver.getTitle().equals("New Window"));
        BrowserUtils.wait(2);
        //driver.close();// driver close will close the current focused window/tab

        // if I want to switch bakc to main page, to continue with some other actions.
        driver.switchTo().window(mainHandle);
        driver.quit();// driver.quit(); will close all tabs/widows that are opened in that session together.


    }

    @Test
    public void p6_handling_more_than_two_windows(){

        driver.get("https://www.Amazon.com");

        // This line is basically : we are downcasting our driver type to JavaScriptExecutor
        // The only thing this line is doing is Using JS EXECUTOR -> opening new tabs with given links
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

        Set<String> windowHandles = driver.getWindowHandles();

        for (String each : windowHandles) {

            BrowserUtils.wait(1);
            driver.switchTo().window(each);
            System.out.println("Current= "+ driver.getTitle());

            if(driver.getCurrentUrl().contains("etsy")){
                Assert.assertTrue(driver.getTitle().contains("Etsy"));
                break;
            }
        }
        WebElement maskButton = driver.findElement(By.xpath("//span[.='Masks']"));
        maskButton.click();
    }
}
