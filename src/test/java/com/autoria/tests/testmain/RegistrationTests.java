package com.autoria.tests.testmain;

import com.autoria.data.DataForRegistrationTests;
import com.autoria.pages.MainPageLogin;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.autoria.config.DriverManager.getDriver;

public class RegistrationTests extends ConfigForTests {
    @Test(dataProvider = "dataForInvalidRegistration", dataProviderClass = DataForRegistrationTests.class)
    public void invalidRegistration(String telephone, String errorMassage) {
        MainPageLogin mainPageLogin = new MainPageLogin(getDriver());
        mainPageLogin.registration(telephone);
        Assert.assertTrue(mainPageLogin.getErrorMessageRegistration().contains(errorMassage), "The registration with invalid data was successfully");
    }
}
