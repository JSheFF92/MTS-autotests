package com.qa.tests;

import com.qa.pages.NewsForThePeriodPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;


public class NewsForThePeriodTest extends BaseTest {

    NewsForThePeriodPage newsPage = new NewsForThePeriodPage();

    @Test
    @Tag("Smoke")
    @Tag("SmokePass")
    @Tag("News")
    @DisplayName("Новости за период 2023 года")
    void newsForThePeriod() {
        step("Open form", () -> {
            mainPage
                    .openPage()
                    .settingsRegistrationPage();
        });

        step("Open news page", () ->
            mainPage
                    .openNewsPage()
        );

        step("Checking the news page", () ->
            newsPage
                    .checkNewsUrlAndNamePage("Новости")
        );

        step("Choice news for 2023", () ->
            newsPage
                    .choiceNewsYear("2023")
        );

        step("Choice period news", () ->
            newsPage
                    .choiceNewsPeriod("Весь год")

        );

        step("Choice categories news", () ->
            newsPage
                    .choiceNewsCategories("Выбрать все")

        );

        step("Check result", () ->
            newsPage
                    .checkFinalResult()
        );
    }
}
