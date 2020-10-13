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


    @Test
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

/*Third Test Case
AC#3
Given as a user, I am at the active stream
When user click on Task tab
And I click on "Add More"
Then select contacts from E-mail, Employees and Departments, and Recent contact lists
And I can assign Employees to different categories: Created By, Participants, and Observer
 */
        BrowserUtils.wait(1);
        WebElement addMoreButton = Driver.getDriver().findElement(By.xpath("//*[@id=\"bx-component-scope-lifefeed_task_form-responsible\"]/span[2]/a[1]"));
        addMoreButton.click();

        BrowserUtils.wait(1);
        WebElement selectContacts = Driver.getDriver().findElement(By.xpath("/html/body/div[8]/div[1]/div/div[1]/a[2]"));
        selectContacts.click();

        BrowserUtils.wait(1);
        WebElement assignEmployee = Driver.getDriver().findElement(By.xpath("//*[@id=\"bx-lm-category-relation-129\"]/a[5]/div[1]/div[1]"));
        assignEmployee.click();

        /*
        AC#4
Given as a user, I am at the active stream
When user click on Task tab
And the user selects a date from date picker
Then user can add Deadline, and Time Planning By
         */
        BrowserUtils.wait(1);
        WebElement deadLine = Driver.getDriver().findElement(By.xpath("//*[@id=\"bx-component-scope-lifefeed_task_form\"]/div/div[3]/div[2]/div/div[1]/span[1]/span/input[1]"));
        deadLine.click();


    }









}
