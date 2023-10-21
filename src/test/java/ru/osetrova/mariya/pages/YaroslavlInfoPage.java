package ru.osetrova.mariya.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class YaroslavlInfoPage {
    public static SelenideElement
            cinemas = $(".active/*[contains(text(),'Кинотеатры')]"),
            title1 = $x("//h2[contains(text(),'КИНОтеатр')]"),
            title2 = $(".title_cinema/*[contains(text(),'КИНОФОРМАТ ЯРОСЛАВЛЬ')]"),
            address = $(".cinema-address"),
            info = $x("//div//p [@class='cinema-desc']"),
            schedule = $(".podr/*[contains(text(),'Расписание')]"),
            room = $(".count-room"),
            telephone = $x("//div[@class='contact-info']//p[1]"),
            emal = $x("//div[@class='contact-info']//p[2]"),
            opening = $x("//div[@class='contact-info']//p[3]");

    @Step("Проверка, что открыт раздел 'Кинотераты' г. Ярославль")
    public void checkQuestionButtons(){
        cinemas.shouldBe(visible);
        cinemas.should(cssValue("color", "rgba(198, 22, 141, 1)"));
        title1.shouldBe(visible);
        title2.shouldBe(visible);
    }
    @Step("Проверка, что отображается корректный адрес кинотеатра в г. Ярославль")
    public void checkCinemaAddress(){
        address.shouldHave(exactText("Ярославль, Проспект Машиностроителей, 30/18, КТРЦ «Яркий»"));
    }
    @Step("Проверка, что отображается информация о зале кинотеатра г. Ярославль")
    public void checkCinemaInfo(){
        info.shouldHave(text("Наслаждайтесь яркой, четкой, насыщенной картинкой, благодаря современным цифровым кинопроекторам и новым экранам с серебряным покрытием. Получите незабываемые эмоции от совершенного, фантастического звука, который появляется из любой точки кинозала, и всё это благодаря современным процессорам и новому акустическому оборудованию. Большие залы с очень комфортными креслами. В фойе кинотеатра расположен снек-бар и зона отдыха с удобными диванами. Приходите расслабиться и насладиться просмотром хорошего фильма. Мы совмещаем новейшие технологии с домашним уютом!"));
    }
    @Step("Проверка, что отображается кнопка просмотра расписания в кинотеатре г. Ярославль")
    public void checkButtonSchedule(){
        schedule.shouldHave(visible);
        $(".podr/*[contains(text(),'Расписание')]").should(cssValue("color", "rgba(33, 37, 41, 1)"));
    }
    @Step("Проверка, что отображается информации о количестве кинозалов и посадочных мест в г. Ярославль")
    public void checkCountRoom(){
        room.shouldHave(exactText("5 кинозалов на 858 посадочных мест."));
    }
    @Step("Проверка, что отображается контактная информация о кинотеатре г. Ярославль")
    public void checkContactInfo(){
        telephone.shouldHave(text("Телефон 8 (4852) 67-44-90"));
        emal.shouldHave(text("Почта info@kino-format.ru"));
        opening.shouldHave(text("Часы работы с 10:00 до 00:00"));
    }

}
