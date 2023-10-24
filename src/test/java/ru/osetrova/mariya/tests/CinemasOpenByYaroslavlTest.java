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
import static com.codeborne.selenide.Condition.text;

import static io.qameta.allure.Allure.step;

@Feature("ИПР")
@Owner("Осетрова Мария") // кто тест писал в отчтете
@Story("Главная страница сайта кинотеатра 'Киноформат'") // название в алюре

public class CinemasOpenByYaroslavlTest extends TestBase {

    KinoteatrHomePage kinoteatrPage = new KinoteatrHomePage();
    СityСonfirmationForms cityСonfirmationForms = new СityСonfirmationForms();
    @Attachment(value = "Скриншот шага", type = "image/png", fileExtension = "png")
    public byte[] attachScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
    @Test
    @DisplayName("Открытрие сайта кинотеатра на главное странице")
    public void cinemasSections() {
        step("Открыта главная страница сайта", () -> {
            kinoteatrPage.checkIsHomePage();
            attachScreenshot();
        });

        step("Отображенеи логотипа", () -> {
            kinoteatrPage.checkLogo();
        });

        step("Отобраение разделов на странице", () -> {
            kinoteatrPage.checkSections();
            attachScreenshot();
        });

        step("Отображение меню навигации", ()->{
            kinoteatrPage
                    .checkNavigationFilms(text("Фильмы"))
                    .checkNavigationSchdeule(text("Расписание"))
                    .checkNavigationStock(text("Акции"));
        });

        step("Отображение формы подтверждения города", () -> {
            cityСonfirmationForms.checkRegionSelectQuestion();
            attachScreenshot();
        });

        step("Выбор города 'Ярославль'", () -> {
            cityСonfirmationForms.selectQuestionButtons();
            attachScreenshot();
        });

    }
}