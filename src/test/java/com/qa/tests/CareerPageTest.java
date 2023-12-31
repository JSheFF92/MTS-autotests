package com.qa.tests;

import com.qa.pages.CareerPage;
import com.qa.pages.ItAndDigitalPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.CRITICAL;


@Owner("Евгений Шевчук")
@Epic(value = "Testing the vacancies page")
@Feature(value = "Main functionality")
@Story("Career in MTS")
public class CareerPageTest extends BaseTest {
    ItAndDigitalPage itAndDigitalPage = new ItAndDigitalPage();
    CareerPage careerPage = new CareerPage();

    @Test
    @Tag("Smoke")
    @Tag("SmokePass")
    @Tag("Vacancies")
    @Severity(CRITICAL)
    @DisplayName("IT Jobs Page")
    void careerInITTest() {
        step("Open form", () -> {
            mainPage
                    .openPage()
                    .settingsRegistrationPage();
        });

        step("Open career", () ->
            mainPage
                    .openCareerPage()
        );

        step("Checking the transition to a section", () ->
            careerPage
                    .checkCareerUrl()
        );
        step("Section Vacancies", () ->
            careerPage
                    .openITAndDigitalSection()
        );

        step("Checking section Vacancies in IT", () -> {
            itAndDigitalPage
                    .checkItAndDigitalUrl()
                    .checkVacanciesText("Вакансии");
        });
    }
}