package com.qa.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;


public class NewsForThePeriodTest extends BaseTest {

    @Test
    @Tag("Smoke")
    @Tag("Smoke_pass")
    @Tag("NewsForPeriodTest")
    @DisplayName("6. News for the period")
    void newsForThePeriod() {
        step("Open form", () -> {
            newsPage
                    .openMTSPage()
                    .settingsRegistrationPage();
        });

        step("Open news page", () ->
            newsPage
                    .openCareerPage()
        );

        step("Checking the news page", () ->
            newsPage
                    .checkNewsUrlAndNamePage("Новости")
        );

        step("Choice news for 2023", () ->
            newsPage
                    .choiceNewsYear()
        );

        step("Choice period news", () ->

            newsPage
                    .choiceNewsPeriod()

        );

        step("Choice categories news", () ->
            newsPage
                    .choiceNewsCategories()

        );

        step("Check result", () ->
            newsPage
                    .checkFinalResult()
        );
    }
}
