package com.autoria.data;

import org.testng.annotations.DataProvider;

public class DataForRegistrationTests {
    @DataProvider
    public Object[] dataForInvalidRegistration() {
        return new Object[][]{{"236lo659", "неверный  мобильный номер телефона"},};
    }
}
