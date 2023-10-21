package ru.osetrova.mariya.helpers;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import ru.osetrova.mariya.config.CredentialsConfig;

public class DriverSettings {
    private static final CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);

    public static void configure() {
        Configuration.browser = config.browser();
        Configuration.browserSize = config.browserSize();
    }
}