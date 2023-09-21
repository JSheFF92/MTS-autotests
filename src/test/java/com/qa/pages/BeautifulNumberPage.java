package com.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class BeautifulNumberPage {

    private final SelenideElement
//                    menuCatalog = $(".middle-menu__catalog-text"),
//                    menuCardList = $(".menu-card.menu-card__list.in-sidebar a:nth-child(4)"),
                    sliderMaxPrice = $("[role='slider'].ngx-slider-pointer-max"),
                    sliderMinPrice = $("[role='slider'].ngx-slider-pointer-min"),
                    choicePriceMax = $("span:nth-child(4) ngx-slider-tooltip-wrapper"),
                    choicePriceMin = $("span:nth-child(3) ngx-slider-tooltip-wrapper"),
                    searchNeedNumber = $("mts-search-form form button"),
                    checkFilterPrice = $x("//*[text()[contains(.,'1 000')]]");

//    public BeautifulNumberPage openMTSPage() {
//        open("/");
//
//        return this;
//    }
//
//    public BeautifulNumberPage settingsRegistrationPage() {
//        executeJavaScript("$('#fixedban').remove()");
//        executeJavaScript("$('footer').remove()");
//
//        return this;
//    }

//    public BeautifulNumberPage goToChoiceNumber(String value) {
//        menuCatalog.click();
//        menuCardList.shouldHave(text(value)).click();
//
//        return this;
//    }

    public BeautifulNumberPage checkChoiceUrl() {
        webdriver().shouldHave(url("https://moskva.mts.ru/personal/vybrat-nomer"));
        return this;
    }

    public BeautifulNumberPage choiceSliderPriceNumber() {
        actions().clickAndHold(sliderMaxPrice).moveToElement(choicePriceMax).release().build().perform();
        actions().clickAndHold(sliderMinPrice).moveToElement(choicePriceMin).release().build().perform();

        return this;
    }

    public BeautifulNumberPage searchNumberWithNeedPrice(String value) {
        searchNeedNumber.click();
        checkFilterPrice.shouldHave(text(value));

        return this;
    }
}