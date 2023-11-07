package com.qa.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.CRITICAL;

@Owner("Евгений Шевчук")
@Epic(value = "News testing")
@Feature(value = "Main functionality")
@Story("News")
public class BalanceFormTest extends BaseTest {

    @Test
    @Tag("Smoke")
    @Tag("SmokePass")
    @Tag("BalanceForm")
    @Severity(CRITICAL)
    @DisplayName("Replenishment of balance form")
    void newsForThePeriod() {
        step("Open form", () -> {
            mainPage
                    .openPage()
                    .settingsRegistrationPage();
        });

        step("Check title balance", () ->
            mainPage.checkTitle("ПОПОЛНЕНИЕ БАЛАНСА")
        );

        step("Check number field", () ->
            mainPage.checkNumberField()
        );

        step("Check amount field", () -> {
            mainPage.checkAmountField();
        });

        step("Check replenishment button", () ->
            mainPage.checkReplenishmentButton("Пополнить")
        );
    }
}