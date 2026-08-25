package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:${env}.properties",
        "classpath:local.properties"
})

public interface WebConfig extends Config {
    @Key("browser")
    @DefaultValue("CHROME")
    String getBrowser();

    @Key("browserVersion")
    String getBrowserVersion();

    @Key("remoteUrl")
    String getRemoteUrl();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String getBrowserSize();

    @Key("baseUrl")
    @DefaultValue("https://befree.ru/")
    String getBaseUrl();

    @Key("headless")
    @DefaultValue("false")
    boolean isHeadless();

    @Key("enableVideo")
    @DefaultValue("true")
    boolean getEnableVideo();

    @Key("videoBaseUrl")
    @DefaultValue("https://user1:1234@selenoid.autotests.cloud/video/<sessionId>.mp4")
    String getVideoBaseUrl();
}
