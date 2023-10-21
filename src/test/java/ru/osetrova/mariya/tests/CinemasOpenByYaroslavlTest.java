package ru.osetrova.mariya.tests;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.osetrova.mariya.pages.KinoteatrHomePage;
import ru.osetrova.mariya.pages.СityСonfirmationForms;

import static io.qameta.allure.Allure.step;

@Feature("ИПР")
@Owner("Осетрова Мария") // кто тест писал в отчтете
@Story("Открытрие сайта кинотеатра 'Киноформат'") // название в алюре

public class CinemasOpenByYaroslavlTest extends TestBase {

    KinoteatrHomePage kinoteatrPage = new KinoteatrHomePage();
    СityСonfirmationForms cityСonfirmationForms = new СityСonfirmationForms();
    @Attachment(value = "Скриншот шага", type = "image/png", fileExtension = "png")
    public byte[] attachScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
    @Test
    @DisplayName("Открытрие сайта кинотеатра с проверкой существующих разделов")
    public void cinemasSections() {
        step("Проверить, что открыта главная страница сайта", () -> {
            kinoteatrPage.homePage();
            attachScreenshot();
        });

        step("Проверить наличие иконки", () -> {
            kinoteatrPage.checkLogo();
        });

        step("Проверить разделы на странице", () -> {
            kinoteatrPage.checkSections();
            attachScreenshot();
        });

        step("Проверить отображение формы подтверждения города", () -> {
            cityСonfirmationForms.checkRegionSelectQuestion();
            attachScreenshot();
        });

        step("Подтвердить город на форме", () -> {
            cityСonfirmationForms.selectQuestionButtons();
            attachScreenshot();
        });

    }
}