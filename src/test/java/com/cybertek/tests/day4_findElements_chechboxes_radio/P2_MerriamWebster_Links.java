package com.cybertek.tests.day4_findElements_chechboxes_radio;

import com.cybertek.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P2_MerriamWebster_Links {
    public static void main(String[] args) {
        //TC #2: FINDELEMENTS
        // 1.Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        // 2.Go to https://www.merriam-webster.com/
        driver.get("https://www.merriam-webster.com/");

        // 3.Print out the texts of all links
        List<WebElement> linksOfLinks = driver.findElements(By.xpath("//body//a"));

        int linksWithoutText = 0;
        int linksWithText = 0;

        for(WebElement eachLink : linksOfLinks){
            String textOfEachLink = eachLink.getText();

            System.out.println(textOfEachLink);

            if(textOfEachLink.isEmpty()){
                linksWithoutText++;
            }else {
                linksWithText++;
            }
        }



        // 4.Print out how many link is missing text
        System.out.println(linksWithoutText);

        // 5.Print out how many link has text
        System.out.println(linksWithText);

        // 6.Print out how many total link
        System.out.println("linksOfLinks.size() = " + linksOfLinks.size());
    }
}
