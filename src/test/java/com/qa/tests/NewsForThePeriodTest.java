package com.qa.tests;

import com.qa.pages.NewsFor2023Page;
import com.qa.pages.NewsForThePeriodPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.NORMAL;

@Owner("Евгений Шевчук")
@Epic(value = "News testing")
@Feature(value = "Main functionality")
@Story("News")
public class NewsForThePeriodTest extends BaseTest {

    NewsForThePeriodPage newsPage = new NewsForThePeriodPage();
    NewsFor2023Page newsFor2023Page = new NewsFor2023Page();

    @Test
    @Tag("Smoke")
    @Tag("SmokePass")
    @Tag("News")
    @Severity(NORMAL)
    @DisplayName("News for the period 2023")
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

        step("Select news for 2023", () ->
            newsPage
                    .selectNewsYear("2023")
        );

        step("Select period news", () ->
            newsPage
                    .selectNewsPeriod("Весь год")

        );

        step("Select categories news", () ->
            newsPage
                    .selectNewsCategories("Выбрать все")

        );

        step("Checking the selected period", () ->
            newsFor2023Page
                    .checkFinalResult()
        );
    }
}
