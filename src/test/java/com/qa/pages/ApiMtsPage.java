package com.qa.pages;

import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class ApiMtsPage {

    private final SelenideElement
                    headerItem = $(".header__top-item_more"),
                    developers = $(".ng-scrollbar-wrapper div:nth-child(6)"),
                    servicesList = $(".dqyHYH"),
                    listAPI = $(".eqUlAG");

//    public ApiMtsPage openMTSPage() {
//        open("/");
//
//        return this;
//    }
//
//    public ApiMtsPage settingsRegistrationPage() {
//        executeJavaScript("$('#fixedban').remove()");
//        executeJavaScript("$('footer').remove()");
//
//        return this;
//    }

//    public ApiMtsPage goToHeaderTopItem() {
//        headerItem.click();
//
//        return this;
//    }
//
//    public ApiMtsPage goToDevelopersPage() {
//        developers.click();
//
//        return this;
//    }

    public ApiMtsPage checkDevelopersUrl() {
        webdriver().shouldHave(url("https://developers.mts.ru/"));

        return this;
    }

    public ApiMtsPage searchServicesList(String value) {
        servicesList.shouldHave(text(value));

        return this;
    }

    public ApiMtsPage checkAPIList() {
        String[] API = new String[]{"Мобильный ID API", "Дизайн-система МТС",
                "МТС Касса API", "Agents API", "Agents API (тестовый стенд)"};
        for (int i = 0; i < API.length; i++) {
            listAPI.shouldHave(text(API[i]));
        }

        return this;
    }
}