package com.cybertek.tests.Project.Bitrix;

import com.cybertek.tests.utilities.BrowserUtils;
import com.cybertek.tests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TaskTab {
    @BeforeMethod
    public void setupMethod(){
    Driver.getDriver().get("https://login2.nextbasecrm.com/stream/");
    Driver.getDriver().manage().window().maximize();
    WebElement userName = Driver.getDriver().findElement(By.name("USER_LOGIN"));
    userName.sendKeys("helpdesk19@cybertekschool.com");
    WebElement password = Driver.getDriver().findElement(By.name("USER_PASSWORD"));
    password.sendKeys("UserUser");
    WebElement loginButton = Driver.getDriver().findElement(By.xpath("//input[@value='Log In']"));
    loginButton.click();
    WebElement taskTabButton = Driver.getDriver().findElement(By.xpath("//span[.='Task']"));
    taskTabButton.click();
    }


    @Test(priority = 1)
/*
AC#1
Given as a user, I am at the active stream
When I click on Task tab
And I click on the "High Priority" checkbox
Then I should be able to prioritize task
 */
    public void highPriority() {

        BrowserUtils.wait(1);
        WebElement highPriorityButton = Driver.getDriver().findElement(By.xpath("//input[@id='tasks-task-priority-cb']"));
        highPriorityButton.click();
    }

//second Test Case
    @Test(priority = 2)
    public void checkList(){
        BrowserUtils.wait(2);
        WebElement checkListButton = Driver.getDriver().findElement(By.xpath("//span[.='Checklist']"));
        checkListButton.click();

        BrowserUtils.wait(1);
        WebElement textInput = Driver.getDriver().findElement(By.xpath("//input[@class='js-id-checklist-is-form-title task-checklist-field-add']"));
        textInput.sendKeys("Complete your task first");

        BrowserUtils.wait(1);
        WebElement checkButton = Driver.getDriver().findElement(By.xpath("//span[@class='js-id-checklist-is-form-submit block-edit tasks-btn-apply task-field-title-ok']"));
        checkButton.click();

        BrowserUtils.wait(1);
        WebElement separator = Driver.getDriver().findElement(By.xpath("//span[@class='js-id-checklist-is-add-separator task-dashed-link-inner']"));
        separator.click();

        BrowserUtils.wait(1);
        WebElement deleteButton = Driver.getDriver().findElement(By.xpath("//span[@class='js-id-checklist-is-i-delete task-field-title-del tasks-btn-delete']"));
        deleteButton.click();

// Third Test Case

    }









}
