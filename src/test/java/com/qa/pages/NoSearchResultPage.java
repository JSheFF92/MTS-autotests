package com.qa.pages;

import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class NoSearchResultPage {

    SelenideElement
            goToHeaderSearchText = $(".header-search__text"),
            goToHeaderSearchInput = $(".header-search__input"),
            nothingFound = $("mts-search-content .mts-search__result-empty");

    public NoSearchResultPage openMTSPage() {
        open("/");

        return this;
    }

    public NoSearchResultPage settingsRegistrationPage() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public NoSearchResultPage openHeaderSearchText() {
        goToHeaderSearchText.click();

        return this;
    }

    public NoSearchResultPage headerSearchInput(String value) {
        goToHeaderSearchInput.setValue(value).pressEnter();

        return this;
    }

    public NoSearchResultPage nothingFoundResult(String value) {
        $("h1").shouldHave(text("Поиск по сайту"));
        $(nothingFound).shouldHave(exactText(value));

        return this;
    }
}