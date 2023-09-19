package com.qa.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class BeautifulNumberTest extends BaseTest {

    @Test
    @Tag("Smoke")
    @Tag("Smoke_pass")
    @Tag("ChoiceNumber")
    @DisplayName("Выбор красивого номера со стоимостью от 1000 до 5000 рублей")
    void choiceBeautifulNumberTest() {
        step("Open main page", () -> {
            beautifulNumber
                    .openMTSPage()
                    .settingsRegistrationPage();
        });

        step("Go to choice number page", () ->
                beautifulNumber
                        .goToChoiceNumber("Выбрать красивый номер")
        );

        step("Select number amount", () -> {
            beautifulNumber
                    .checkChoiceUrl()
                    .choiceSliderPriceNumber();
        });

        step("Checking the selection result", () ->
                beautifulNumber
                        .searchNumberWithNeedPrice("1 000")
        );
    }
}