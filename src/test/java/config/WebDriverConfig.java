package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/remote.properties"})

public interface WebDriverConfig extends Config {

    @Key("remoteUrl")
    String remoteUrl();

}
