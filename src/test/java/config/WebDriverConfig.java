package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/remote.properties"})

public interface WebDriverConfig extends Config {

    @Key("browser")
    @DefaultValue("CHROME")
    String browser();

    @Key("browserSize")
    @DefaultValue("1900x900")
    String browserSize();

    @Key("versionBrowser")
    @DefaultValue("96.0")
    String versionBrowser();

    @Key("remoteUrl")
    String remoteUrl();

}
