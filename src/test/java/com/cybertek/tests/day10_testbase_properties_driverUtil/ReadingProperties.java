package com.cybertek.tests.day10_testbase_properties_driverUtil;

import com.cybertek.tests.utilities.ConfigurationReader;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingProperties {

    @Test
    public void reading_from_properties_file() throws IOException {

        // properties: use properties class object
        // We creat properties object to be able to read configuration.properties file
        Properties properties = new Properties();

        // FileInputStream: opens the file
        String path = "configuration.properties";

        // we need to pass the path of the file we want to open in JVM
        FileInputStream file = new FileInputStream(path);

        // We will load the file
        properties.load(file);

        // We read from the file
        System.out.println("properties.getProperty(\"browser\") = " + properties.getProperty("browser"));
        System.out.println("properties.getProperty(\"username\") = " + properties.getProperty("username"));
        // Close the file

    }

    @Test
    public void ussing_properties_utility_method(){
        System.out.println("ConfigurationReader.getProperty(\"browser\") = " + ConfigurationReader.getProperty("browser"));
        System.out.println("ConfigurationReader.getProperty(\"smartbearUrl\") = " + ConfigurationReader.getProperty("smartbearUrl"));
    }
}
