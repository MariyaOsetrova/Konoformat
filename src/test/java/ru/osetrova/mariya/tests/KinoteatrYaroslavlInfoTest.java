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
import ru.osetrova.mariya.pages.YaroslavlInfoPage;
import ru.osetrova.mariya.pages.СityСonfirmationForms;

import static io.qameta.allure.Allure.step;
@Feature("ИПР")
@Owner("Осетрова Мария") // кто тест писал в отчете
@Story("Открытрие сайта кинотеатра 'Киноформат'") // название в аллюре
public class KinoteatrYaroslavlInfoTest extends TestBase {
    KinoteatrHomePage kinoteatrPage = new KinoteatrHomePage();
    СityСonfirmationForms cityСonfirmationForms = new СityСonfirmationForms();
    YaroslavlInfoPage yaroslavlInfo = new YaroslavlInfoPage();
    @Attachment(value = "Скриншот шага", type = "image/png", fileExtension = "png")
    public byte[] attachScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
    @Test
    @DisplayName("Проверка информации о кинотеатре в г. Ярославль")
    public void cinemasSections() {
        step("Подтверждение города 'Ярославль'", () -> {
            cityСonfirmationForms.selectQuestionButtons();
            attachScreenshot();
        });

        step("Перейти в раздел 'Кинотераты' г. Ярославль", () -> {
            kinoteatrPage.openCinemas();
            attachScreenshot();
        });

        step("Проверка, что открыт раздел 'Кинотераты' г. Ярославль", () -> {
            yaroslavlInfo.checkQuestionButtons();
        });

        step("Проверка, что отображается корректрный адрес кинотеатра г. Ярославль", () -> {
            yaroslavlInfo.checkCinemaAddress();
        });

        step("Проверка, что отображается информация о зале кинотеатра г. Ярославль", () -> {
            yaroslavlInfo.checkCinemaInfo();
        });

        step("Проверка, что отображается кнопка просмотра расписания в кинотеатре г. Ярославль", () -> {
            yaroslavlInfo.checkButtonSchedule();
        });

        step("Проверка, что отображается кнопка просмотра расписания в кинотеатре г. Ярославль", () -> {
            yaroslavlInfo.checkCountRoom();
        });

        step("Проверка, что отображается контактная информация о кинотеатре г. Ярославль", () -> {
            yaroslavlInfo.checkContactInfo();
            attachScreenshot();
        });
    }
}
