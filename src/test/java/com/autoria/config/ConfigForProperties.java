package com.autoria.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static com.autoria.config.DriverType.CHROME;

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
            case CHROME:
                driverPath = props.getProperty("chromeDriverPath");
                break;
            case FIREFOX:
                driverPath = props.getProperty("firefoxDriverPath");
                break;
            case IE:
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

    public static DriverType getBrowser() {
        String browserName = props.getProperty("browser");
        if (browserName == null || browserName.equals("chrome")) return CHROME;
        else if (browserName.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
        else if (browserName.equals("iexplorer")) return DriverType.IE;
        else
            throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
    }

}
