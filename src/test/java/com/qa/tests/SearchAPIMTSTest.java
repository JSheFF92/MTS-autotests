package com.qa.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class SearchAPIMTSTest extends BaseTest {

    @Test
    @Tag("Smoke")
    @Tag("Smoke_pass")
    @Tag("SearchAPIMTS")
    @DisplayName("Search API MTS")
    void searchAPIMTSTest() {
        step("Open main page", () -> {
            open("https://moskva.mts.ru");
            searchAPIMTS
                    .openMTSPage()
                    .settingsRegistrationPage();
        });

        step("Developers go to services", () -> {
            searchAPIMTS
                    .goToHeaderTopItem()
                    .goToDevelopersPage();
        });

        step("Check Developers page and services", () -> {
            searchAPIMTS
                    .checkDevelopersUrl()
                    .searchServicesList("СПИСОК СЕРВИСОВ");
        });

        step("Services APIs are present on the page", () ->
            searchAPIMTS
                    .checkAPIList()
        );
    }
}