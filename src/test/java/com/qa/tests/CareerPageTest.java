package com.qa.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class CareerPageTest extends BaseTest {

    @Test
    @Tag("Smoke")
    @Tag("Smoke_pass")
    @Tag("VacanciesInIT")
    @DisplayName("Section Vacancies in IT")
    void careerInITTest() {
        step("Open form", () -> {
            careerPage
                    .openMTSPage()
                    .settingsRegistrationPage();
        });

        step("Open career", () ->
            careerPage
                    .openCareerPage()
        );

        step("Checking the transition to a section", () ->
            careerPage
                    .checkCareerUrl()
        );
        step("Section Vacancies in IT", () -> {
            careerPage
                    .openITAndDigitalSection()
                    .checkVacanciesText("Вакансии");
        });
    }
}