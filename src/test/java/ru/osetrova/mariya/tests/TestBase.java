package ru.osetrova.mariya.tests;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import ru.osetrova.mariya.helpers.DriverSettings;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class TestBase {
    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DriverSettings.configure();
    }
    @BeforeEach
    @DisplayName("Открыть главную страницу сайта kino-format.ru")
    void openHomePage() {
        step("Открытие главное страницы сайта kino-format.ru", () ->
                open("https://kino-format.ru")
        );
    }
}
