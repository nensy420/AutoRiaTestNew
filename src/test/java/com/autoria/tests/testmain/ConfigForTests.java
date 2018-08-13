package com.autoria.tests.testmain;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.autoria.config.ConfigForProperties.getUrl;
import static com.autoria.config.DriverManager.*;


public class ConfigForTests {

    private static final Logger log = LogManager.getLogger(ConfigForTests.class);

    @Step("{0}")
    private static void logToAllure(String logger) {
        log.info(logger);
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] saveScreenshot(WebDriver driver) {
        logToAllure("Screenshot have been added to Allure Report.");
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @BeforeMethod
    public void openPage() {
        getDriver().get(getUrl());
        logToAllure(" Launch Auto Ria page");
    }

    @AfterMethod
    public void closePage(ITestResult result) {
        if (!result.isSuccess()) {
            saveScreenshot(getDriver());
        }
        quitDriver();
        logToAllure("Close Auto Ria");
    }
}
