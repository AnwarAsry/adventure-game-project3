package se.sprinto.hakan.adventuregame;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class AppInfo {
    // static variable instance of type AppInfo
    private static AppInfo appInstance = null;

    Properties properties = new Properties();

    private AppInfo() {
        try {
            // Reads the characters
            FileReader fileReader = new FileReader("config.properties");
            properties.load(fileReader);
        } catch (IOException e) {
            System.out.println("Error cold not load properties: " + e);
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static AppInfo getInstance() {
        // To ensure only one instance is created
        if (appInstance == null) {
            appInstance = new AppInfo();
        }
        return appInstance;
    }
}
