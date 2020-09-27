package com.cybertek.tests.day3_cssSelectro_xpath;

import com.cybertek.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P4_PracticeCybertek_Xpath {

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybetschool.com/multiple_buttons");

        WebElement button2 = driver.findElement(By.xpath("//button[@name='button2'"));
        button2.click();
    }
}
