package com.autoria.data;

import org.testng.annotations.DataProvider;

public class DataForHeadersLinks {

    @DataProvider
    public Object[] dataForLinkRiaComTest() {
        return new Object[][]{{"Ria.com", "RIA.com ™ — доска бесплатных частных объявлений Украины.", "https://www.ria.com/"},};
    }

    @DataProvider
    public Object[] dataForLinkNeruhimistTest() {
        return new Object[][]{{"Нерухомість", "DOM.RIA™ — вся недвижимость Украины. Продажа и аренда любой недвижимости.", "https://dom.ria.com/?utm_source=auto_ria&utm_medium=text_link&utm_content=nedvigimost&utm_campaign=header"},};
    }

    @DataProvider
    public Object[] dataForLinkAutotovaryTest() {
        return new Object[][]{{"Автотовари", "MARKET.RIA — шины, диски и аксессуары для авто по выгодным ценам", "https://market.ria.com/?utm_source=auto.ria.com&utm_medium=text_link&utm_content=magazin_avtotovarov&utm_campaign=header"},};
    }

    @DataProvider
    public Object[] dataForLinkAutozapchastinyTest() {
        return new Object[][]{{"Автозапчастини", "1 000 000+ запчастей на авто в Украине на ZAPCHASTI.RIA", "https://zapchasti.ria.com/"},};
    }


}
