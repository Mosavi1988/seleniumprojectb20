package com.cybertek.tests.day5_testNG_intro_dropdowns;

import com.cybertek.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class P05_SeleniumEasy_Task1 {
    public static void main(String[] args)throws InterruptedException {

        //TC #2:	SeleniumEasy	CheckboxVerification–Section	1
        // 1.Open	Chrome	browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        // 2.Go	to	https://www.seleniumeasy.com/test/basic-checkbox-demo.html
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        // Locate success message and checkbox under'sngle checkbox demo'
        WebElement successCheckbox = driver.findElement(By.xpath("//input[@id='isAgeSelected']"));

        // locate the success message
        WebElement successMessage = driver.findElement(By.xpath("//div[@id='txtAge']"));

        // 3.Verify	“Success	–Check	box	is	checked”	message	is	NOTdisplayed.
        if(!successMessage.isDisplayed()){
            System.out.println("Success Message is not displayed. Verification PASSED!");
        }else {
            System.out.println("success Message is displayed. Verification FAILED!!!");
        }

        // 4.Click	to	checkbox	under	“Single	Checkbox	Demo”	section
        successCheckbox.click();
        // 5.Verify	“Success	–Check	box	is	checked”	message	isdisplayed.
        if(successMessage.isDisplayed()){
            System.out.println("Success Message is displayed. Verification PASSED!");
        }else {
            System.out.println("success Message is not displayed. Verification FAILED!!!");
        }

        Thread.sleep(3000);
        driver.close();



    }
}
