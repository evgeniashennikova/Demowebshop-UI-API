package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/credential.properties"})

public interface UserCredential extends Config {

    String cookie();

    String login();

    String password();

    String firstName();

    String lastName();

    String email();

}
