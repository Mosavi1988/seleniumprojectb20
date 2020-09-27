package com.cybertek.tests.day4_findElements_chechboxes_radio;

import com.cybertek.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P3_Checkbox_Practice {
    public static void main(String[] args) {
        //Practice: Cybertek Checkboxes
        //1. Go to http://practice.cybertekschool.com/checkboxes
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");

        // Locating the first checkbox
        WebElement checkbox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));

        //Locating the second checkbox
        WebElement checkbox2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));


        //2. Confirm checkbox #1 is NOT selected by default
        if(!checkbox1.isSelected()){
            System.out.println("checkbox 1 is not selected. Verification PASSED!");
        }else {
            System.out.println("checkbox 1 is selected. Verification FAILED!!!");
        }

        //3. Confirm checkbox #2 is SELECTED by default.
        if(checkbox2.isSelected()){
            System.out.println("checkbox 2 is selected. Verification PASSED!");
        }else {
            System.out.println("checkbox 2 is not selected. Verification FAILED!!!");
        }
        //4. Click checkbox #1 to select it.
        checkbox1.click();

        //5. Click checkbox #2 to deselect it.
        checkbox2.click();

        //6. Confirm checkbox #1 is SELECTED.
        if(checkbox1.isSelected()){
            System.out.println("checkbox 1 is selected. Verification PASSED!");
        }else {
            System.out.println("checkbox 1 is not selected. Verification FAILED!!!");
        }

        //7. Confirm checkbox #2 is NOT selected.
        if(!checkbox2.isSelected()){
            System.out.println("checkbox 2 is not selected. Verification PASSED!");
        }else {
            System.out.println("checkbox 2 is selected. Verification FAILED!!!");
        }

        
    }
}
