package com.autoria.pages;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.autoria.tools.Waiters.waitToBeClickable;

public class MainPageLogin {
    private WebDriver driver;

    @FindBy(xpath = "//div[@id='header']//div[@class='container']//span[@class='tl']")
    private WebElement enterTo;

    @FindBy(xpath = "//form[@id='login-form']/following-sibling::div[@class='login-link']/a")
    private WebElement registerLink;

    @FindBy(xpath = "//div[@class='login-rows']//following-sibling::input")
    private WebElement telephoneField;

    @FindBy(xpath = "//div[@class='sub-button']//following-sibling::input")
    private WebElement continueButton;

    @FindBy(id = "emailloginform-email")
    private WebElement emailField;

    @FindBy(id = "emailloginform-password")
    private WebElement passwardField;

    @FindBy(xpath = "//form[@id='login-form']/child::div[@class='login-link']//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//form[@id='login-form']/child::div[@class='login-rows']//p[@class='error']")
    private WebElement fieldAttantion;

    private static final Logger log = LogManager.getLogger(MainPageLogin.class);

    private void clickOnEnterAndSwitchToFrame() {
        waitToBeClickable(enterTo).click();
        logToAllure("Click on login link");
        driver.switchTo().frame("login_frame");
        logToAllure("Switch to frame");
    }

    private void clickOnRegister() {
        waitToBeClickable(registerLink).click();
        logToAllure("Click on registration link");
    }

    private void inputTelephone(String number) {
        waitToBeClickable(telephoneField).sendKeys(number);
        logToAllure("Input the telephone number");
    }

    private void clickOnContinueButton() {
        waitToBeClickable(continueButton).click();
        logToAllure(" Click on the continue button");
    }

    @Step("{0}")
    private static void logToAllure(String logger) {
        log.info(logger);
    }

    public MainPageLogin(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void registration(String number) {
        clickOnEnterAndSwitchToFrame();
        clickOnRegister();
        inputTelephone(number);
        clickOnContinueButton();
    }

    public String getErrorMessageRegistration() {
        String attantionMessage = fieldAttantion.getAttribute("innerHTML");
        logToAllure(" Get the message");
        return attantionMessage;
    }

}
