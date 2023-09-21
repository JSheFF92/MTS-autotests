package com.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class NewsForThePeriodPage {

    private final SelenideElement
                    newsNamePage = $(".section-box__title"),
                    widgetChoiceYear = $("[id='mat-select-value-1']"),
                    widgetYear = $(".mat-select-old-ds__select-panel"),
                    widgetChoicePeriod = $("[id='mat-select-2']"),
                    widgetPeriod = $(".mat-select-old-ds__select-panel"),
                    widgetChoiceCategories = $("[id='mat-select-4']"),
                    widgetCategories = $("#mat-checkbox-1"),
                    checkResult = $x("//*[contains(text(), '.2023')]");

    public NewsForThePeriodPage checkNewsUrlAndNamePage(String value) {
        webdriver().shouldHave(url("https://moskva.mts.ru/personal/novosti"));
        newsNamePage.shouldHave(text(value));

        return this;
    }

    public NewsForThePeriodPage choiceNewsYear(String value) {
        widgetChoiceYear.click();
        widgetYear.$(byText(value)).click();


        return this;
    }

    public NewsForThePeriodPage choiceNewsPeriod(String value) {
        widgetChoicePeriod.click();
        widgetPeriod.$(byText(value)).click();

        return this;
    }

    public NewsForThePeriodPage choiceNewsCategories(String value) {
        widgetChoiceCategories.click();
        widgetCategories.$(byText(value)).click();

        return this;
    }

    public NewsForThePeriodPage checkFinalResult() {
        checkResult.shouldHave(visible);

        return this;
    }
}