package com.qa.tests;

import com.qa.pages.MobileServicePage;
import com.qa.pages.SpamCallsArchivePage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.MINOR;

@Owner("Евгений Шевчук")
@Epic(value = "Archive testing")
@Feature(value = "Minor functionality")
@Story("Archive")
public class SpamCallsIsArchivedTest extends BaseTest {

    MobileServicePage mobileServicePage = new MobileServicePage();
    SpamCallsArchivePage spamCallsIsArchivedPage = new SpamCallsArchivePage();

    @Test
    @Tag("Smoke")
    @Tag("SmokePass")
    @Tag("SpamCalls")
    @Severity(MINOR)
    @DisplayName("Archived service 'Blocking spam calls'")
    void archiveSpamCallsTest() {
        step("Open main page", () -> {
            open("https://moskva.mts.ru");
            mainPage
                    .openPage()
                    .settingsRegistrationPage();
        });

        step("Go to section 'Services and options'", () ->
            mainPage
                    .goToSectionServicesAndOptions()
        );

        step("Go to archive", () -> {
            mobileServicePage
                    .checkMobileServices("Услуги мобильной связи")
                    .goToArchive();
        });

        step("Select archive block calls", () ->
        spamCallsIsArchivedPage
                    .goChoiceArchiveService("Блокировка спам-звонков")
        );

        step("Checking the selected section", () ->
            spamCallsIsArchivedPage
                    .checkRightService("Блокировка спам-звонков")
        );
    }
}