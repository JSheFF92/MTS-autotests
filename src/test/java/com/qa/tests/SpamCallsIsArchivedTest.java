package com.qa.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class SpamCallsIsArchivedTest extends BaseTest {

    @Test
    @Tag("Smoke")
    @Tag("Smoke_pass")
    @Tag("BlockSpamCalls")
    @DisplayName("Архивная услуга 'Блокирование спам звонков'")
    void archiveSpamCallsTest() {
        step("Open main page", () -> {
            open("https://moskva.mts.ru");
            spamCallsIsArchived
                    .openMTSPage()
                    .settingsRegistrationPage();
        });

        step("Go to section 'Services and options'", () -> {
            spamCallsIsArchived
                    .goToSectionServicesAndOptions()
                    .checkMobileServices("Услуги мобильной связи");
        });

        step("Go to archive", () ->
            spamCallsIsArchived
                    .goToArchive()
        );

        step("Choice mobile services", () -> {
            spamCallsIsArchived
                    .goToArchiveList("Звонки")
                    .goChoiceArchiveService("Блокировка спам-звонков")
                    .checkRightService("Блокировка спам-звонков");
        });
    }
}