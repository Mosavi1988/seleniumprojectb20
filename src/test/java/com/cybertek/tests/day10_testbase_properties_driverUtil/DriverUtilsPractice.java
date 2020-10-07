package com.cybertek.tests.day10_testbase_properties_driverUtil;

import com.cybertek.tests.utilities.ConfigurationReader;
import com.cybertek.tests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DriverUtilsPractice {

    @Test
    public void simple_google_search_test(){
        // Driver.getDriver() =
        Driver.getDriver().get("https://google.com");
        WebElement searchBox = Driver.getDriver().findElement(By.name("q"));
        String search = ConfigurationReader.getProperty("searchValue");

        searchBox.sendKeys("wooden spoon"+ Keys.ENTER);

        String expectedResult = "wooden spoon";

        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedResult));



    }

}
