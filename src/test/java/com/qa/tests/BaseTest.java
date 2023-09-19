package com.qa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.qa.helpers.Attach;
import com.qa.pages.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Selenide.*;

public class BaseTest {
    CareerPage careerPage = new CareerPage();
    NoSearchResultPage noSearchResult = new NoSearchResultPage();
    SpamCallsIsArchivedPage spamCallsIsArchived = new SpamCallsIsArchivedPage();
    APIMTSPage searchAPIMTS = new APIMTSPage();
    BeautifulNumberPage beautifulNumber = new BeautifulNumberPage();
    NewsForThePeriodPage newsPage = new NewsForThePeriodPage();

    @BeforeAll
    static void beforeAll() {
////        open("https://moskva.mts.ru/");
        Configuration.baseUrl = "https://moskva.mts.ru";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
////        executeJavaScript("$('#fixedban').remove()");
////        executeJavaScript("$('footer').remove()");
//        Configuration.browser = System.getProperty("browser", "chrome");
//        Configuration.baseUrl = System.getProperty("baseUrl", "https://moskva.mts.ru");
//        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
//        Configuration.browserVersion = System.getProperty("browserVersion", "100.0");
//        Configuration.pageLoadStrategy = "eager";
//        Configuration.timeout = 10000;
//        Configuration.remote = System.getProperty("selenoidBaseUrl", "https://user1:1234@selenoid.autotests.cloud/wd/hub");
//
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
//                "enableVNC", true,
//                "enableVideo", true
//        ));
//
//        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

        closeWebDriver();
    }
}