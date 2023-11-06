package com.qa.tests;

import com.qa.pages.NoSearchResultPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.NORMAL;

@Owner("Евгений Шевчук")
@Epic(value = "Search testing")
@Feature(value = "Main functionality")
@Story("Search")
public class FailedSearchResultTest extends BaseTest {

    NoSearchResultPage noSearchResultPage = new NoSearchResultPage();

    @Test
    @Tag("Smoke")
    @Tag("SmokeFailed")
    @Tag("FailedSearch")
    @Severity(NORMAL)
    @DisplayName("No search results")
    void careerInITTest() {
        step("Open form", () -> {
            mainPage
                    .openPage()
                    .settingsRegistrationPage();
        });

        step("Search", () -> {
            mainPage
                    .openHeaderSearchText()
                    .search("Hello, I'm Evgeniy and I'm looking for a job");
        });

        step("Checking error message", () ->
            noSearchResultPage
                     .nothingFoundResult("По вашему запросу ничего не найдено")
        );
    }
}