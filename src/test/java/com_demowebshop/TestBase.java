package com_demowebshop;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com_demowebshop.attach.Attach;
import com_demowebshop.steps.ApiSteps;
import com_demowebshop.steps.WebSteps;
import config.WebDriverConfig;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import static java.lang.Thread.sleep;

public class TestBase {

    ApiSteps apiSteps = new ApiSteps();
    WebSteps webSteps = new WebSteps();
    public static WebDriverConfig webConfig = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

    @BeforeAll
    static void setUp() {

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        RestAssured.baseURI = "http://demowebshop.tricentis.com";
        Configuration.baseUrl = "http://demowebshop.tricentis.com";

        Configuration.remote = webConfig.remoteUrl();
        Configuration.browser = webConfig.browser();
        Configuration.browserSize = webConfig.browserSize();
        Configuration.browserVersion = webConfig.versionBrowser();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;

    }

    @BeforeEach
    void sleepUp() throws InterruptedException {

        sleep(500);

    }

    @AfterEach
    public void tearDown() {

        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

}
