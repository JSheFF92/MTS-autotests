package com.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SpamCallsIsArchivedPage {

    private final SelenideElement
                    goToServicesAndOptions = $(".navigations__cards-wrapper a:nth-child(2"),
                    checkServices = $("h1"),
                    goArchive = $("mts-button .mts-button--color--ghost"),
                    archiveList = $(".archive-list"),
                    choiceArchiveServices = $(".filters__content-item div:nth-child(2) a"),
                    rightChoice = $("h1");

    public SpamCallsIsArchivedPage openMTSPage() {
        open("/");

        return this;
    }
    public SpamCallsIsArchivedPage settingsRegistrationPage() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public SpamCallsIsArchivedPage goToSectionServicesAndOptions() {
        goToServicesAndOptions.click();

        return this;
    }

    public SpamCallsIsArchivedPage checkMobileServices(String value) {
        checkServices.shouldHave(text(value));

        return this;
    }

    public SpamCallsIsArchivedPage goToArchive() {
        $(".mat-dialog-content button").click();
        goArchive.shouldHave(text("Архивные услуги")).click();

        return this;
    }

    public SpamCallsIsArchivedPage goToArchiveList(String value) {
        archiveList.shouldHave(text(value)).click();

        return this;
    }

    public SpamCallsIsArchivedPage goChoiceArchiveService(String value) {
        choiceArchiveServices.shouldHave(text(value)).click();

        return this;
    }

    public SpamCallsIsArchivedPage checkRightService(String value) {
        rightChoice.shouldHave(text(value));

        return this;
    }
}