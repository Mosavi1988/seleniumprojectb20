package com.cybertek.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    public static void main(String[] args) throws InterruptedException {

        // 1- Setup the driver
        WebDriverManager.chromedriver().setup();

        // 2- Create instance of the driver
        WebDriver driver = new ChromeDriver();

        // 3- Use the driver instance to test selenium
        driver.get("https://WWW.google.com");

        System.out.println("The title of the page is: "+driver.getTitle());

        String actualTitle = driver.getTitle();
        System.out.println("Actual Title String: "+actualTitle);

        String actualUrl = driver.getCurrentUrl();
        System.out.println("ActualUrl: "+actualUrl);

        String expectedUrl = driver.getCurrentUrl();
        System.out.println("expectedUrl = " + expectedUrl);

        Thread.sleep(3000);

        driver.navigate().back();

        Thread.sleep(3000);
        driver.navigate().forward();

        Thread.sleep(3000);
        driver.navigate().refresh();

        Thread.sleep(3000);
        driver.navigate().to("https:/WWW.facebook.com");


    }
}
