package com.qa.tests;

import com.qa.pages.BeautifulNumberPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.BLOCKER;

@Owner("Евгений Шевчук")
@Epic(value = "Number selection testing")
@Feature(value = "Main functionality")
@Story("Buying a number")

public class BeautifulNumberTest extends BaseTest {

    BeautifulNumberPage beautifulNumberPage = new BeautifulNumberPage();

    @Test
    @Tag("Smoke")
    @Tag("SmokePass")
    @Tag("ChoiceNumber")
    @Severity(BLOCKER)
    @DisplayName("Choosing a beautiful room with a cost from 1000 to 5000 rubles")
    void choiceBeautifulNumberTest() {
        step("Open main page", () -> {
            mainPage
                    .openPage()
                    .settingsRegistrationPage();
        });

        step("Go to choice number page", () ->
                mainPage
                        .goToNumberPage("Выбрать красивый номер")
        );

        step("Select number amount", () -> {
            beautifulNumberPage
                    .checkChoiceUrl()
                    .selectSliderPriceNumber();
        });

        step("Checking the selection result", () ->
                beautifulNumberPage
                        .searchNumberWithNeedPrice("1 000")
        );
    }
}