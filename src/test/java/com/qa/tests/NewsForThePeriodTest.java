package com.qa.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;


public class NewsForThePeriodTest extends BaseTest {

    @Test
    @Tag("Smoke")
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
//            $(".footer__menu a:nth-child(7)").click();
        );

        step("Checking the news page", () ->
            newsPage
                    .checkNewsUrlAndNamePage("Новости")
//            webdriver().shouldHave(url("https://moskva.mts.ru/personal/novosti"));
//            $("h1").shouldHave(text("Новости"));

        );
        step("Choice news for 2023", () ->
//
//            $("[id='mat-select-value-1']").click();
//            $(".mat-select-old-ds__select-panel :nth-child(2) .mat-option-text").click();
            newsPage
                    .choiceNewsYear()
        );

        step("Choice period news", () ->
//                    $("[id='mat-select-2']").click();
////
//            $(".mat-select-old-ds__select-panel :nth-child(1) .mat-option-text").click();

            newsPage
                    .choiceNewsPeriod()

        );

        step("Choice categories news", () ->
//                    $("[id='mat-select-4']").click();
//                      $("[id='mat-checkbox-1']").click();
            newsPage
                    .choiceNewsCategories()

        );

        step("Check result", () ->
//                    $("[id='mat-select-4']").click();
//                      $("[id='mat-checkbox-1']").click();

            newsPage
                    .checkFinalResult()
        );
    }
}
