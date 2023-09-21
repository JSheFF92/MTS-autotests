package com.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class CareerPage {

    private final SelenideElement
                    buttonITAndDigital = $x("//a[contains(text(), 'IT и Digital')]"),
                    vacanciesPageText = $("#app");

    public CareerPage checkCareerUrl() {
        webdriver().shouldHave(url("https://job.mts.ru/"));

        return this;
    }

    public CareerPage openITAndDigitalSection() {
        buttonITAndDigital.click();

        return this;
    }

    public CareerPage checkVacanciesText(String value) {
        vacanciesPageText.shouldHave(text(value));

        return this;
    }
}