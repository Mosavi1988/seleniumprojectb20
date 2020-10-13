package com.cybertek.tests.day12_review_jsexecutor_pom;

import com.cybertek.tests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class UploadPractice {

    @Test
    public void uploading_file_test(){

        Driver.getDriver().get("http://practice.cybertekschool.com/upload");
        Driver.getDriver().manage().window().maximize();

        String path = "/Users/sayedhassanmosavi/Desktop/UNADJUSTEDNONRAW_thumb_80b.jpg";

        WebElement uploadInput = Driver.getDriver().findElement(By.id("file-upload"));

        uploadInput.sendKeys(path);



    }
}
