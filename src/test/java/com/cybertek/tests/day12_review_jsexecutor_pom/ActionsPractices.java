package com.cybertek.tests.day12_review_jsexecutor_pom;

import com.cybertek.tests.utilities.Driver;
import org.testng.annotations.Test;

public class ActionsPractices {
    /*
TC #16: Double Click Test
1. Go to https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
2. Switch to iframe.
3. Double click on the text "Double-click me to change my text color."
4. Assert: Text's "style" attribute value contains "red".
 */

    @Test
    public void p2_double_click_test(){

        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");

        //2. Switch to iframe.
        Driver.getDriver().switchTo().frame("iframeResult");
    }



}
