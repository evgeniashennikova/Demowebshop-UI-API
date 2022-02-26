package com.demowebshop.config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static java.lang.String.format;

public class WebDriverConfig {

    private final static ProjectConfig webConfig = ConfigFactory.create(ProjectConfig.class, System.getProperties());

    public static void webConfiguration() {

        Configuration.browser = webConfig.browser();
        Configuration.browserVersion = webConfig.versionBrowser();
        Configuration.browserSize = webConfig.browserSize();
        Configuration.timeout = 10000;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--enable-automation");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--ignore-certificate-errors");

        Configuration.remote = format("https://%s:%s@%s",
                webConfig.login(), webConfig.password(), webConfig.selenoidUrl());
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;

    }
}
