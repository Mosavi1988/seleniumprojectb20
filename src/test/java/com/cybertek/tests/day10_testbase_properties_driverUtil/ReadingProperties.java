package com.cybertek.tests.day10_testbase_properties_driverUtil;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadingProperties {

    @Test
    public void reading_from_properties_file() throws FileNotFoundException {

        // properties: use properties class object
        // We creat properties object to be able to read configuration.properties file
        Properties properties = new Properties();

        // FileInputStream: opens the file
        String path = "configuration.properties";

        // we need to pass the path of the file we want to open in JVM
        FileInputStream file = new FileInputStream(path);
        // We will load the file
        // We read from the file
        // Close the file



    }
}
