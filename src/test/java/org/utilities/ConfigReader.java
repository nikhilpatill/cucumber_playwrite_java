package org.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static final String FILE_PATH = "./src/test/resources/org/propertiesFiles/Config.properties";

    // Get single value
    public String getPropData(String key) {
        try (FileInputStream fis = new FileInputStream(FILE_PATH)) {

            Properties prop = new Properties();
            prop.load(fis);
            return prop.getProperty(key);

        } catch (IOException e) {
            System.out.println("❌ Unable to read property: " + key);
            e.printStackTrace();
            return null;
        }
    }


    // Get all properties
    public Properties getProp() {
        try (FileInputStream fis = new FileInputStream(FILE_PATH)) {

            Properties prop = new Properties();
            prop.load(fis);
            return prop;

        } catch (IOException e) {
            System.out.println("❌ Unable to load Config.properties");
            e.printStackTrace();
            return null;
        }
    }
}
