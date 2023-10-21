package ru.osetrova.mariya.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class СityСonfirmationForms {
    public static SelenideElement
            yar = $x("//div[contains(text(),'Ваш город Ярославль?')]"),
            formSelectQuestion = $("div.regions-select-question"),
            titleForm = $("div.regions-select-question-text"),
            yesButton = $("div.regions-select-question-buttons button:nth-child(1)"), //элементы внутри родительского элемента https://developer.mozilla.org/en-US/docs/Web/CSS/:nth-child
            noButton = $("div.regions-select-question-buttons button:nth-child(2)"), // https://htmlbook.ru/css/nth-child
            regions = $(".regions-select-region/*[contains(text(),'Ярославль')]"),
            regionsWindow = $(".regions-select-dialog-window"),
            regionsWindowYar = $x("//div[contains(text(),'Ярославль')]");
    @Step("Отображение формы поддтверждение города")
    public void checkRegionSelectQuestion(){
        formSelectQuestion.shouldBe(visible); // проверка отображения формы
        titleForm.shouldBe(visible);
        yesButton.shouldHave(text("Да"));
        noButton.shouldHave(text("Нет"));
        sleep(3000);
    }

    @Step("Подтверждение/выбор города Ярославля")
    public void selectQuestionButtons(){
        if(yar.exists()) { // наличие элемента
            yesButton.click();
            regions.shouldBe(visible).should(cssValue("color", "rgba(45, 45, 45, 1)"));
        }
        else {
            noButton.click();
            regionsWindow.shouldBe(visible);
            regionsWindowYar.click();
            regions.shouldBe(visible).should(cssValue("color", "rgba(45, 45, 45, 1)"));
        }
    }
}
