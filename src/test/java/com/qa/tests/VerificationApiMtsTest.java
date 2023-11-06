package com.qa.tests;

import com.qa.pages.ApiMtsPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.MINOR;

@Owner("Евгений Шевчук")
@Epic(value = "API page testing")
@Feature(value = "Minor functionality")
@Story("API")
public class VerificationApiMtsTest extends BaseTest {

    ApiMtsPage verificationAPIMTSPage = new ApiMtsPage();

    @Test
    @Tag("Smoke")
    @Tag("SmokePass")
    @Tag("ApiMts")
    @Severity(MINOR)
    @DisplayName("Checking the MTS API list")
    void searchAPIMTSTest() {
        step("Open main page", () -> {
            open("https://moskva.mts.ru");
            mainPage
                    .openPage()
                    .settingsRegistrationPage();
        });

        step("Developers go to services", () -> {
            mainPage
                    .goToHeaderTopItem()
                    .goToDevelopersPage();
        });

        step("Check Developers page and services", () -> {
            verificationAPIMTSPage
                    .checkDevelopersUrl()
                    .searchServicesList("СПИСОК СЕРВИСОВ");
        });

        step("Checking section services APIs are present on the page", () ->
            verificationAPIMTSPage
                    .checkAPIList(new String[]{"Мобильный ID API", "Дизайн-система МТС",
                            "МТС Касса API", "Agents API", "Agents API (тестовый стенд)"})
        );
    }
}