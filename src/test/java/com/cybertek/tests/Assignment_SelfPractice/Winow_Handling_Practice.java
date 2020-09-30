package com.cybertek.tests.Assignment_SelfPractice;
/*
TC	#	:	Window	Handlepractice
1.Create	a	new	class	called:	WindowHandlePractice
2.Create	new	test	and	make	set	ups
3.Go	to	:	http://practice.cybertekschool.com/windows
4.Assert:	Title	is	“Practice”
5.Click	to:	“Click	Here”text
6.Switch	to	new	Window.
7.Assert:	Title	is	“New	Window”
 */

import com.cybertek.tests.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Winow_Handling_Practice {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/windows");
    }

    @Test
    public void handling_windows(){

        String actualResult = driver.getTitle();
        Assert.assertTrue(actualResult.equals("Practice"));

        System.out.println("actualResult = " + actualResult);

        WebElement clickHereText = driver.findElement(By.xpath("//a[.='Click Here']"));
        BrowserUtils.wait(2);
        clickHereText.click();

        String newTitle = driver.getTitle();
        System.out.println("newTitle = " + newTitle);

        String mainHandle = driver.getWindowHandle();
        System.out.println("mainHandle = " + mainHandle);

        Set<String> windowHandles = driver.getWindowHandles();
        for (String each : windowHandles) {
            driver.switchTo().window(each);
            System.out.println("Current Title: "+driver.getTitle());
        }

        Assert.assertTrue(driver.getTitle().equals("New Window"));
        BrowserUtils.wait(2);

        driver.switchTo().window(mainHandle);
        BrowserUtils.wait(3);
        driver.quit();
    }

    @Test
    public void handling_more_than_two_windows(){

        driver.get("https://www.amazon.com");

        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

        Set<String> windowHandles = driver.getWindowHandles();
        for (String each : windowHandles) {
            BrowserUtils.wait(1);
            driver.switchTo().window(each);
            System.out.println("Current Title: "+driver.getTitle());

            if(driver.getCurrentUrl().contains("amazon")){
                Assert.assertTrue(driver.getTitle().contains("Amazon"));
                break;
            }

            WebElement bestSeller = driver.findElement(By.xpath("//a[.='Customer Service']"));
            BrowserUtils.wait(2);
            bestSeller.click();


        }


    }


}
