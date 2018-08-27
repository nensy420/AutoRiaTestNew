package com.autoria.tools;

import org.openqa.selenium.WebElement;

public class Actions {
    public static String getInnerHtml(WebElement elm) {
        String result = elm.getAttribute("innerHTML");
        return result;
    }
}
