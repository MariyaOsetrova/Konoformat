package ru.osetrova.mariya.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class KinoteatrHomePage {

    public static SelenideElement
            logo = $("[id=for_static] .logo"),
            todayСinema = $(".today-in-cinema-section"),
            movies = $x("//*[contains(text(),'Фильмы')]"),
            schedule = $x("//nav/a[2]"),
            cinemas = $x("//nav/a[contains(text(),'Кинотеатры')]"),        // $("nav a:nth-child(3)").shouldHave(text("Кинотеатры"));
            stock = $("nav a:nth-child(4)"),
            information = $("nav a:nth-child(5)"),
            hallRental = $("nav a:nth-child(6)");

    @Step("Проверка открытия страницы кинотеатра")
    public void homePage(){
        webdriver().shouldHave(url("https://kino-format.ru/")); // проверка урла
        todayСinema.shouldHave(text("Сегодня в кинотеатрах"));
    }
    @Step("Проверка наличия логотипа страницы кинотеатра")
    public void checkLogo(){
        logo.shouldBe(visible); // проверка логотипа
    }
    @Step("Проверка существующих разделов")
    public void checkSections(){
        movies.shouldBe(visible);
        schedule.shouldHave(text("Расписание"));
        cinemas.shouldBe(visible);
        stock.shouldHave(text("Акции"));
        information.shouldHave(text("Информация"));
        hallRental.shouldHave(text("Аренда зала"));
    }
    @Step("Открыть раздел 'Кинотеатры' ")
    public void openCinemas(){
        cinemas.click();
    }

}
