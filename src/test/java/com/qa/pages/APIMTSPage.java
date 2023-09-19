package com.qa.pages;

import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class APIMTSPage {

    private final SelenideElement
            headerItem = $(".header__top-item_more"),
            developers = $(".ng-scrollbar-wrapper div:nth-child(6)"),
            servicesList = $(".dqyHYH"),
            listAPI = $(".eqUlAG");

    public APIMTSPage openMTSPage() {
        open("/");

        return this;
    }

    public APIMTSPage settingsRegistrationPage() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public APIMTSPage goToHeaderTopItem() {
        headerItem.click();

        return this;
    }

    public APIMTSPage goToDevelopersPage() {
        developers.click();

        return this;
    }

    public APIMTSPage checkDevelopersUrl() {
        webdriver().shouldHave(url("https://developers.mts.ru/"));

        return this;
    }

    public APIMTSPage searchServicesList(String value) {
        servicesList.shouldHave(text(value));

        return this;
    }

    public APIMTSPage checkAPIList() {
        String[] API = new String[]{"Мобильный ID API", "Дизайн-система МТС",
                "МТС Касса API", "Agents API", "Agents API (тестовый стенд)"};
        for (int i = 0; i < API.length; i++) {
            listAPI.shouldHave(text(API[i]));
        }

        return this;
    }
}