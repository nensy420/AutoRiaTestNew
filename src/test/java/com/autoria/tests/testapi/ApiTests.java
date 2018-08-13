package com.autoria.tests.testapi;

import com.autoria.data.DataForApiTests;
import com.autoria.data.DataForApiTests.*;
import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class ApiTests {
    private static final Logger log = LogManager.getLogger(ApiTests.class);
    private String key = "api_key=Q7qNVxdwbZV6xGmpD37IjPjy0AuCRmkYK5lNnRpd";

    @Step("{0}")
    private static void logToAllure(String logger) {
        log.info(logger);
    }

    @Test()
    public void descriptionTest() {
        given().get("https://developers.ria.com/auto/info?" + key + "&auto_id=22304245").
                then().
                statusCode(200).
                body("autoData.description", equalTo("ЧИСТЫЙ-2013г.в. в ТП.,производство-30;09;2013г.в!!БЕЗ пробега по Украине!!ОТЛИЧНОЕ состояние-НЕ БИТ-100%!!*ОРИГИНАЛЬНЫЙ-МАЛЕНЬКИЙ пробег-1000%-гарантирован(а это-большая РЕДКОСТЬ),в наличии АКТЫ выполненных работ на СТО-06;07;2018г-сделано ПОЛНОЕ обслуживание,авто в ОТЛИЧНОМ техническом состоянии-на руках ЗАКЛЮЧЕНИЕ СЕРВИСНОГО центра!!МОЩНЫЙ и супер ЭКОНОМИЧНЫЙ двигатель 5л./100км!!БОГАТАЯ комплектация-Система динамической стабилизации;Противобуксовочная система;ПОЛНЫЙ-электропакет;Мультируль;Телефон-блютуз;Кондиционер;Бортовой компьютер с монитором;Акустическая система;Парктроники с звуковым сигналом;Электропривод зеркал+Подогрев зеркал;Подогрев стекла;Подогрев сидений;Электро-стеклоподъемники и мн.др. функций-для ВАШЕГО комфорта и безопасности!!ЦЕЛЫЙ-Живой-как технически так и визуально-готов к любым проверкам!!МОЩНАЯ,ДИНАМИЧНАЯ,ЭКОНОМНАЯ,НАДЕЖНАЯ-рабочая лошадка-для БИЗНЕСА и домашнего пользования,мягкая в ходу-ДЕШЕВЫЙ в обслуживании!!В наличии ВСЕ документы для регистрации и постановки на учет!!MIN ТОРГ!"));
        logToAllure("The auto data description is correctly");
    }

    @Test()
    public void markaIdTest() {
        given().get("https://developers.ria.com/auto/new/models?marka_id=9&category_id=1&" + key).
                then().
                statusCode(200).
                body("marka_id[0]", equalTo(9));
        logToAllure("The marka id that was given in the request coincides with response");
    }

    @Test()
    public void countOfPageTest() {
        given().get("https://developers.ria.com/new_to_old?" + key + "&categories.main.id=1&brand.id%5B0%5D=9&year%5B0%5D.gte=2011&year%5B0%5D.lte=2016&custom.not=1&fuel.id%5B5%5D=6&gearbox.id%5B1%5D=2&gearbox.id%5B2%5D=3&size=10%22&countpage=10").
                then().
                statusCode(200).
                body("unrecognized.countpage", equalTo("10"));
        logToAllure("The count of pages that was given in the request coincides with response");
    }

    @Test()
    public void brandNameTest() {
        given().get("https://developers.ria.com/auto/info?" + key + "&auto_id=22443775").
                then().
                statusCode(200).
                body("markName", equalTo("Land Rover"));
        logToAllure("The name of brand car that was given in the request coincides with response");
    }

    @Test(dataProvider = "dataForTestCities", dataProviderClass = DataForApiTests.class)
    public void namesOfCitiesTest(TestData data) {
        given().get("https://developers.ria.com/auto/states/1/cities?" + key).then().statusCode(200).body("name", hasItems(data.get(2), data.get(5), data.get(7)));
        logToAllure("The names of cities " + data.get(2) + " " + data.get(5) + " " + data.get(7) + " are contained in the response.");
    }

    @Test(dataProvider = "dataOptions", dataProviderClass = DataForApiTests.class)
    public void optionsTest(TestData options) {
        given().get("https://developers.ria.com/auto/categories/1/options?" + key).then().statusCode(200).body("name", hasItems(options.get(2), options.get(5), options.get(7)));
        logToAllure("The names of options " + options.get(2) + " " + options.get(5) + " " + options.get(7) + " are contained in the response.");
    }
}
