//package com.qa.config;
//
//import org.aeonbits.owner.Config;
//
//@Config.Sources({
//        "classpath:properties/${env}.properties",
//})
//
//public interface WebDriverConfig extends Config {
//
//    @Key("baseUrl")
//    @DefaultValue("https://moskva.mts.ru")
//    String baseUrl();
//
//    @Key("browser")
//    @DefaultValue("CHROME")
//    String browser();
//
//    @Key("browserVersion")
//    @DefaultValue("100.0")
//    String browserVersion();
//
//    @Key("isRemote")
//    @DefaultValue("false")
//    Boolean isRemote();
//
//    @Key("remoteUrl")
//    @DefaultValue("http://localhost:4444")
//    String remoteUrl();
//
//
//}
