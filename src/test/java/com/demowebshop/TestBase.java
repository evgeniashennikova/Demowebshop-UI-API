package com.demowebshop;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.demowebshop.steps.ApiSteps;
import com.demowebshop.steps.WebSteps;
import com.demowebshop.config.WebDriverConfig;
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
        WebDriverConfig.webConfiguration();

        RestAssured.baseURI = "http://demowebshop.tricentis.com";
        Configuration.baseUrl = "http://demowebshop.tricentis.com";
    }

    @BeforeEach
    void sleepUp() throws InterruptedException {
        // Добавлен sleep так как API-тесты в Jenkins проходили не стабильно.
        sleep(1000);
    }
}

