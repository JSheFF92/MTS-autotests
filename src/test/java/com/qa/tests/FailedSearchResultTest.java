package com.qa.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class FailedSearchResultTest extends BaseTest {

    @Test
    @Tag("Smoke")
    @Tag("Smoke_failed")
    @Tag("FailedSearchResult")
    @DisplayName("Отсутвие результатов поиска")
    void careerInITTest() {
        step("Open form", () -> {
            noSearchResult
                    .openMTSPage()
                    .settingsRegistrationPage();
        });

        step("Search", () -> {
            noSearchResult
                    .openHeaderSearchText()
                    .headerSearchInput("Hello, I'm Evgeniy and I'm looking for a job");
        });

        step("Nothing found for your request", () ->
            noSearchResult
                     .nothingFoundResult("По вашему запросу ничего не найдено")
        );
    }
}