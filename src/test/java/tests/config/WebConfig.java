package tests.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        // подстановка local или remote
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
}
