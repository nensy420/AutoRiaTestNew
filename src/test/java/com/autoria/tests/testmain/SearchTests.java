package com.autoria.tests.testmain;


import com.autoria.data.DataForSearchTests;
import com.autoria.pages.MainPageSearch;
import com.autoria.pages.SearchPageResults;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.autoria.config.DriverManager.getDriver;

public class SearchTests extends ConfigForTests {

    @Test(dataProvider = "dataForSearchYear", dataProviderClass = DataForSearchTests.class)
    public void yearTest(String yearFrom, String yearTo) {
        MainPageSearch mainPageSearch = new MainPageSearch(getDriver());
        SearchPageResults searchPageResults = mainPageSearch.selectYear(yearFrom, yearTo);
        Assert.assertTrue(searchPageResults.getResultsOfSearchYear(yearFrom, yearTo), "The result of search for the year are not valid");
    }

    @Test(dataProvider = "dataForSearchBrandAndMark", dataProviderClass = DataForSearchTests.class)
    public void brandAndMarkTest(String brandName, String markName) {
        MainPageSearch mainPageSearch = new MainPageSearch(getDriver());
        SearchPageResults searchPageResults = mainPageSearch.searchNameCar(brandName, markName);
        Assert.assertTrue(searchPageResults.resultsOfSearchBrandAndMark(brandName, markName), "The result of search for the brand and mark are not valid");
    }

    @Test(dataProvider = "dataForSearchRegion", dataProviderClass = DataForSearchTests.class)
    public void regionTest(String regionName,String listOfCitis) {
        MainPageSearch mainPageSearch = new MainPageSearch(getDriver());
        SearchPageResults searchPageResults = mainPageSearch.searchRegion(regionName);
        Assert.assertTrue(searchPageResults.getResultsOfSearchRegion(listOfCitis), "The result of search for the region are not valid");
    }

    @Test(dataProvider = "dataForSearchPrice", dataProviderClass = DataForSearchTests.class)
    public void priceTest(String priceFrom, String priceTo) {
        MainPageSearch mainPageSearch = new MainPageSearch(getDriver());
        SearchPageResults searchPageResults = mainPageSearch.enterPrice(priceFrom, priceTo);
        Assert.assertTrue(searchPageResults.getResultsOfSearchPrice(priceFrom, priceTo), "The result of search for the price are not valid");
    }
}
