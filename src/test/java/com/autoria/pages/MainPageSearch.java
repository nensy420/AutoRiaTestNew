package com.autoria.pages;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static com.autoria.config.DriverManager.getDriver;
import static com.autoria.tools.Actions.getInnerHtml;
import static com.autoria.tools.Waiters.waitToBeClickable;

public class MainPageSearch {
    private WebDriver driver;

    @FindBy(id = "categories")
    private WebElement transportField;

    @FindBy(xpath = "//input[@id='brandTooltipBrandAutocompleteInput-brand']/following-sibling::label")
    private WebElement brandCarField;

    @FindBy(xpath = "//div[@id='brandTooltipBrandAutocomplete-brand']//ul//following-sibling::li/a")
    private List<WebElement> brandCarList;

    @FindBy(xpath = "//div[@id='brandTooltipBrandAutocomplete-model']/label")
    private WebElement modelCarField;

    @FindBy(xpath = "//div[@id='brandTooltipBrandAutocomplete-model']//ul//following-sibling::li/a")
    private List<WebElement> modelCarList;

    @FindBy(xpath = "//div[contains(@class,'secondary-column')]//div[@class='m-indent']//label[@for='regionAutocompleteAutocompleteInput-1']")
    private WebElement regionField;

    @FindBy(xpath = "//div[@class='autocomplete-search mhide']//ul/li/a")
    private List<WebElement> regionList;

    @FindBy(id = "yearFrom")
    private WebElement yearFromField;

    @FindBy(id = "yearTo")
    private WebElement yearToField;

    @FindBy(id = "priceFrom")
    private WebElement priceFromField;

    @FindBy(id = "priceTo")
    private WebElement priceToField;

    @FindBy(xpath = "//form[@id='mainSearchForm']/div[@class='footer-form']/button")
    private WebElement submit;

    @FindBy(xpath = "//input[@id='buRadioType']/following-sibling::label[@for='buRadioType']")
    private WebElement buRadioButton;

    @FindBy(xpath = "//input[@id='naRadioType']/following-sibling::label[@for='naRadioType']")
    private WebElement newRadioButton;

    private static final Logger log = LogManager.getLogger(MainPageSearch.class);

    @Step("{0}")
    private static void logToAllure(String logger) {
        log.info(logger);
    }

    public MainPageSearch(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public SearchPageResults searchTransport(String transportName) {
        Select selectTransportField = new Select(transportField);
        selectTransportField.selectByVisibleText(transportName);
        logToAllure("Select transport");
        submit.click();
        logToAllure("Click search button");
        return new SearchPageResults(getDriver());
    }

    public void selectBrandCar(String nameBrandCar) {
        waitToBeClickable(brandCarField).click();
        List<WebElement> listBrandCar = brandCarList;
        for (WebElement elm : listBrandCar) {
            String dataValue = getInnerHtml(elm);
            if (dataValue.contains(nameBrandCar)) {
                waitToBeClickable(elm).click();
                logToAllure("Select car brand");
                break;
            }
        }
    }

    public void selectModelCar(String nameModelCar) {
        waitToBeClickable(modelCarField).click();
        List<WebElement> listModelCar = modelCarList;
        for (WebElement elm : listModelCar) {
            String dataValue = getInnerHtml(elm);
            if (dataValue.contains(nameModelCar)) {
                waitToBeClickable(elm).click();
                logToAllure("Select car model");
                break;
            }
        }
    }

    public SearchPageResults searchNameCar(String nameBrandCar, String nameModelCar) {
        selectBrandCar(nameBrandCar);
        selectModelCar(nameModelCar);
        submit.click();
        logToAllure("Click search button");
        return new SearchPageResults(getDriver());
    }

    public SearchPageResults searchRegion(String nameRegion) {
        waitToBeClickable(regionField).click();
        List<WebElement> listRegions = regionList;
        for (WebElement elm : listRegions) {
            String dataValue = getInnerHtml(elm);
            if (dataValue.contains(nameRegion)) {
                waitToBeClickable(elm).click();
                logToAllure("Select region");
                break;
            }
        }
        submit.click();
        logToAllure("Click search button");
        return new SearchPageResults(getDriver());
    }

    public SearchPageResults selectYear(String from, String to) {
        Select yearSelectFrom = new Select(yearFromField);
        yearSelectFrom.selectByValue(from);
        logToAllure("Select year from");
        Select yearSelectTo = new Select(yearToField);
        yearSelectTo.selectByVisibleText(to);
        logToAllure("Select year to");
        submit.click();
        logToAllure("Click search button");
        return new SearchPageResults(getDriver());
    }

    public SearchPageResults enterPrice(String priceFrom, String priceTo) {
        priceFromField.sendKeys(priceFrom);
        logToAllure("Select price from");
        priceToField.sendKeys(priceTo);
        logToAllure("Select price to");
        submit.click();
        logToAllure("Click search button");
        return new SearchPageResults(getDriver());
    }
}
