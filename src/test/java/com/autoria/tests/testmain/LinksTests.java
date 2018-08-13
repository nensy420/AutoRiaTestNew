package com.autoria.tests.testmain;

import com.autoria.data.DataForHeadersLinks;
import com.autoria.pages.MainPageHeaderLinks;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.autoria.config.DriverManager.*;


public class LinksTests extends ConfigForTests{

    @Test(dataProvider = "dataForLinkRiaComTest",dataProviderClass = DataForHeadersLinks.class)
    public void linkRiaComTest( String linkName, String expectedTitle,String expectedUrl){
        MainPageHeaderLinks mainPageHeaderLinks = new MainPageHeaderLinks(getDriver());
       Assert.assertTrue( mainPageHeaderLinks.checkOpenLinkRiaCom( linkName, expectedTitle,expectedUrl), "The Ria.com page was not loaded");
    }

    @Test(dataProvider = "dataForLinkNeruhimistTest",dataProviderClass = DataForHeadersLinks.class)
    public void linkNeruhomistTest( String linkName, String expectedTitle,String expectedUrl){
        MainPageHeaderLinks mainPageHeaderLinks = new MainPageHeaderLinks(getDriver());
        Assert.assertTrue( mainPageHeaderLinks.checkOpenLinkNeruhomist( linkName, expectedTitle,expectedUrl), "The Ria.com page was not loaded");
    }

    @Test(dataProvider = "dataForLinkAutotovaryTest",dataProviderClass = DataForHeadersLinks.class)
    public void linkAutotovaryTest( String linkName, String expectedTitle,String expectedUrl){
        MainPageHeaderLinks mainPageHeaderLinks = new MainPageHeaderLinks(getDriver());
        Assert.assertTrue( mainPageHeaderLinks.checkOpenLinkAutotovary( linkName, expectedTitle,expectedUrl), "The Ria.com page was not loaded");
    }

    @Test(dataProvider = "dataForLinkAutozapchastinyTest", dataProviderClass = DataForHeadersLinks.class)
    public void linkAutozapchastinyTest( String linkName, String expectedTitle,String expectedUrl){
        MainPageHeaderLinks mainPageHeaderLinks = new MainPageHeaderLinks(getDriver());
        Assert.assertTrue( mainPageHeaderLinks.checkOpenLinkAutozapchastiny( linkName, expectedTitle,expectedUrl), "The Ria.com page was not loaded");
    }
}
