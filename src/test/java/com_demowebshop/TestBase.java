package com_demowebshop;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com_demowebshop.steps.ApiSteps;
import com_demowebshop.steps.WebSteps;
import config.WebDriverProvider;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static java.lang.Thread.sleep;

public class TestBase {

    ApiSteps apiSteps = new ApiSteps();
    WebSteps webSteps = new WebSteps();

    @BeforeAll
    static void setUp() {

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        WebDriverProvider.webConfiguration();

        RestAssured.baseURI = "http://demowebshop.tricentis.com";
        Configuration.baseUrl = "http://demowebshop.tricentis.com";

    }

    @BeforeEach
    void sleepUp() throws InterruptedException {

        sleep(1000);

    }

}
