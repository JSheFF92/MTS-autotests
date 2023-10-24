package com.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SpamCallsArchivePage {

    private final SelenideElement
                    checkResult = $("h1"),
                    archiveServices = $(".alphabetical-list div:nth-child(3) div:nth-child(2) div:nth-child(2)");

    public SpamCallsArchivePage goChoiceArchiveService(String value) {
        archiveServices.shouldHave(text(value)).click();

        return this;
    }

    public SpamCallsArchivePage checkRightService(String value) {
        checkResult.shouldHave(text(value));

        return this;
    }
}