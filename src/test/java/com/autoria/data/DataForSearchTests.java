package com.autoria.data;

import org.testng.annotations.DataProvider;

public class DataForSearchTests {

    @DataProvider
    public Object[] dataForSearchYear() {
        return new Object[][]{{"2006", "2008"}, {"2010", "2016"}, {"2003", "2018"}};
    }

    @DataProvider
    public Object[] dataForSearchBrandAndMark() {
        return new Object[][]{{"Audi", "Q7"}, {"BMW", "X5"}, {"Honda", "Accord"}};
    }

    @DataProvider
    public Object[] dataForSearchRegion() {
        return new Object[][]{{"Львов"}, {"Киев"}, {"Одесса"}};
    }

    @DataProvider
    public Object[] dataForSearchPrice() {
        return new Object[][]{{"2000", "10000"}, {"10000", "20000"}, {"20000", "50000"}};
    }
}