package ru.osetrova.mariya.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class KinoteatrHomePage {

    private SelenideElement

            navigationPanel = $("[id=for_static].header-nav"),
            logo = navigationPanel.find(".logo"), //$("[id=for_static] .logo")
            todayСinema = $(".today-in-cinema-section"),
            movies = navigationPanel.find("nav a:first-child"),//$x("//*[contains(text(),'Фильмы')]"),
            schedule = navigationPanel.find("a[href='/raspisanie/']"),// $x("//nav/a[2]"),
            cinemas = navigationPanel.find(By.xpath(".//nav/a[contains(text(),'Кинотеатры')]")),//$x("//nav/a[contains(text(),'Кинотеатры')]"),        // $("nav a:nth-child(3)").shouldHave(text("Кинотеатры"));
            stock = $("nav a:nth-child(4)"),
            information = navigationPanel.find(By.xpath(".//*[contains(text(),'Информация')]")),//$("nav a:nth-child(5)"),
            hallRental = navigationPanel.find("nav a:last-child");//$("nav a:nth-child(6)");

    @Step("Проверка открытия страницы кинотеатра")
    public void checkIsHomePage(){
        webdriver().shouldHave(url("https://kino-format.ru/")); // проверка урла
        todayСinema.shouldHave(text("Сегодня в кинотеатрах"));
    }
    @Step("Проверка наличия логотипа страницы кинотеатра")
    public void checkLogo(){
        logo.shouldBe(visible); // проверка логотипа
    }
    @Step("Проверка существующих разделов")
    public void checkSections(){
        movies.shouldHave(text("Фильмы"));//shouldBe(visible);
        schedule.shouldHave(text("Расписание"));
        cinemas.shouldBe(visible);
        stock.shouldHave(text("Акции"));
        information.shouldHave(text("Информация"));
        hallRental.shouldHave(text("Аренда зала"));
    }
    @Step("Проверка {condition} для раздела навигации Фильмы")
    public KinoteatrHomePage checkNavigationFilms(Condition condition){
        movies.should(condition);
        return this;
    }
    @Step("Проверка {condition} для раздела навигации Расписание")
    public KinoteatrHomePage checkNavigationSchdeule(Condition condition){
        schedule.should(condition);
        return this;
    }
    @Step("Проверка {condition} для раздела навигации Акции")
    public KinoteatrHomePage checkNavigationStock(Condition condition){
        stock.should(condition);
        return this;
    }
    @Step("Открыть раздел 'Кинотеатры' ")
    public void openCinemas(){
        cinemas.click();
    }

}
