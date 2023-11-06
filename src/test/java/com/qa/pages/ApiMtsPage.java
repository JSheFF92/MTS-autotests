package com.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class ApiMtsPage {

    private final SelenideElement
            servicesList = $(".dqyHYH"),
            listAPI = $(".eqUlAG");

    public ApiMtsPage checkDevelopersUrl() {
        webdriver().shouldHave(url("https://developers.mts.ru/"));

        return this;
    }

    public ApiMtsPage searchServicesList(String value) {
        servicesList.shouldHave(text(value));

        return this;
    }

    public ApiMtsPage checkAPIList(String[] value) {
        for (String ApiServices : value) {
            listAPI.shouldHave(text(ApiServices));
        }

        return this;
    }
}