package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P3_NavigationAndTitleVerification {

    public static void main(String[] args) {

        //TC #3: Back and forth navigation
        // 1- Open a chrome browser
        WebDriverManager.chromedriver().setup();

        // Open browser
        WebDriver driver = new ChromeDriver();

        //2- Go to https://WWW.googl.com
        driver.get("https://WWW.google.com");

        //3- Click to Gmail from top right.
        driver.findElement(By.linkText("Gmail")).click();
        //4- Verify title contains
        //Expected: Gmail
        String expectedInTitle = "Gmail";
        String actualTitle = driver.getTitle();
        if(actualTitle.contains(expectedInTitle)){
            System.out.println("Title Verification PASSED!");
        }else {
            System.out.println("Title Verification FAILED!!!");
        }
        //5- Go back to google by using the .back();
        driver.navigate().back();

        //6- Verify title equals
        // Expected: Google
        String expectedGoogleTitle = "Google";
        String actualGoogleTitle = driver.getTitle();

        if(actualGoogleTitle.equals(expectedGoogleTitle)){
            System.out.println("Title Verificatin PASSED!");
        }else {
            System.out.println("Title Verificaion FAILED!!!");
        }










    }
}
