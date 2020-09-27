package com.cybertek.tests.Project.VytrackTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Vytrack_Login {
    public static void main(String[] args ) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa2.vytrack.com/user/login");
        String[] usernames = {"user169", "storemanager219", "salesmanager269"};
        String password = "UserUser123";
        for(String username : usernames){
            WebElement userNameInput = driver.findElement(By.id("prependedInput"));
            WebElement passwordInput = driver.findElement(By.id("prependedInput2"));
            WebElement loginButton = driver.findElement(By.id("_submit"));

            userNameInput.sendKeys(username);
            passwordInput.sendKeys(password);
            loginButton.click();
            Thread.sleep(100);

        }


    }
}
