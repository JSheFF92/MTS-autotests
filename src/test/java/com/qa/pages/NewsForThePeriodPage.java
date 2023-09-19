package com.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class NewsForThePeriodPage {

    SelenideElement
            buttonOpenNews = $(".footer__menu a:nth-child(7)"),
            newsNamePage = $(".section-box__title"),
            widgetChoiceYear = $("[id='mat-select-value-1']"),
            widgetYear = $(".mat-select-old-ds__select-panel :nth-child(2) .mat-option-text"),
            widgetChoicePeriod = $("[id='mat-select-2']"),
            widgetPeriod = $(".mat-select-old-ds__select-panel :nth-child(1) .mat-option-text"),
            widgetChoiceCategories = $("[id='mat-select-4']"),
            widgetCategories = $("#mat-checkbox-1 span.mat-checkbox-label"),
            checkResult = $x("//*[contains(text(), '.2023')]");


    public NewsForThePeriodPage openMTSPage() {
        open("/");

        return this;
    }

    public NewsForThePeriodPage settingsRegistrationPage() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public NewsForThePeriodPage openCareerPage() {
        buttonOpenNews.click();

        return this;
    }

    public NewsForThePeriodPage checkNewsUrlAndNamePage(String value) {
        webdriver().shouldHave(url("https://moskva.mts.ru/personal/novosti"));
        newsNamePage.shouldHave(text(value));

        return this;
    }

    public NewsForThePeriodPage choiceNewsYear() {
        widgetChoiceYear.click();
        widgetYear.click();

        return this;
    }

    public NewsForThePeriodPage choiceNewsPeriod() {
        widgetChoicePeriod.click();
        widgetPeriod.click();

        return this;
    }

    public NewsForThePeriodPage choiceNewsCategories() {
        widgetChoiceCategories.click();
        widgetCategories.click();

        return this;
    }

    public NewsForThePeriodPage checkFinalResult() {
        checkResult.shouldHave(visible);

        return this;
    }
}