package com.autoria.config;

import java.io.*;
import java.util.Properties;

public class ConfigForProperties {

    private static final Properties props;
    private static File file = new File("src/test/resources/config.properties");
    private static FileInputStream fileInputStream;

    static {
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        props = new Properties();
        try {
            props.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getDriverPath() {
        String driverPath = null;
        switch (getBrowser()) {
            case "chrome":
                driverPath = props.getProperty("chromeDriverPath");
                break;
            case "firefox":
                driverPath = props.getProperty("firefoxDriverPath");
                break;
            case "IE":
                driverPath = props.getProperty("IEDriverPath");
                break;
        }

        if (driverPath != null) {
            return driverPath;
        } else {
            throw new RuntimeException("driverPath not specified in the config.properties file.");
        }
    }

    public static String getUrl() {
        String url = props.getProperty("URL");
        if (url != null) {
            return url;
        } else {
            throw new RuntimeException("url not specified in the config.properties file.");
        }
    }

    public static String getBrowser() {
       String browser = props.getProperty("browser");
        return browser;
    }

}
