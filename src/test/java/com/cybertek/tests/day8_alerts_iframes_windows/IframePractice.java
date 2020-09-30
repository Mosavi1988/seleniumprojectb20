package com.cybertek.tests.day8_alerts_iframes_windows;

import com.cybertek.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IframePractice {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/iframe");

    }

    @Test
    public void p4_iframe_practice(){

        //3 ways of locating.
        //1- by index
        //driver.switchTo().frame(0);
        //2- by id or name
        //driver.switchTo().frame("mce_0_ifr");

        //3- locate as a web element, then switch to it
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);

        //Locating paragraph tag as a web element
        WebElement yourContentGoesHereText = driver.findElement(By.xpath("//p"));

        //Assert that the text is displayed on the page
        Assert.assertTrue(yourContentGoesHereText.isDisplayed(), "Text is not displayed. Verification Failed!!!");

        //5. Assert: " An iFrame containing the TynyMCE WYSMCE Editor.
        driver.switchTo().defaultContent();
        driver.switchTo().parentFrame();

        WebElement headerText = driver.findElement(By.xpath("//h3"));

        Assert.assertTrue(headerText.isDisplayed(), "Header is not displayed. Verification Failed!!!");
    }

}
