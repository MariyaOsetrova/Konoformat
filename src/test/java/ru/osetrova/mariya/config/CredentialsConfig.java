package ru.osetrova.mariya.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/local.properties"})
public interface CredentialsConfig extends Config {
    @Key("browser")
    String browser();
    @Key("browserSize")
    String browserSize();
}
