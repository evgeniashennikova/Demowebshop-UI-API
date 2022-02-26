package com.demowebshop.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:configs/projectConfig.properties"
})

public interface ProjectConfig extends Config {

    String selenoidUrl();

    String login();

    String password();

    @Config.Key("browser")
    @Config.DefaultValue("CHROME")
    String browser();

    @Config.Key("versionBrowser")
    @Config.DefaultValue("91.0")
    String versionBrowser();

    @Config.Key("browserSize")
    @Config.DefaultValue("1920x1080")
    String browserSize();

}
