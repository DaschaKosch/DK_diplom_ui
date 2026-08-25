package config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelenideSetup {

    public static void applyConfig() {
        String env = System.getProperty("env", "local");
        WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());
        Configuration.browser = config.getBrowser().toLowerCase();

        if (config.getBrowserVersion() != null && !config.getBrowserVersion().isEmpty()) {
            Configuration.browserVersion = config.getBrowserVersion();
        }

        Configuration.browserSize = config.getBrowserSize();
        Configuration.baseUrl = config.getBaseUrl();
        Configuration.headless = config.isHeadless();
        Configuration.timeout = 15000;

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("selenoid:options", Map.of(
                "enableVNC", true,
                "enableVideo", config.getEnableVideo(),
                "screenResolution", System.getProperty("browserResolution", "1920x1080")
        ));

        if (config.isHeadless()) {
            List<String> args = new ArrayList<>();
            args.add("--no-sandbox");
            args.add("--disable-dev-shm-usage");
            args.add("--disable-gpu");
            args.add("--window-size=1920,1080");
            args.add("--force-color-profile=srgb");
            args.add("--disable-software-rasterizer");

            Map<String, Object> chromeOptions = new HashMap<>();
            chromeOptions.put("args", args);
            capabilities.setCapability("goog:chromeOptions", chromeOptions);
        }

        Configuration.browserCapabilities = capabilities;

        String remoteUrl = config.getRemoteUrl();
        if (remoteUrl != null && !remoteUrl.isEmpty()) {

            if (remoteUrl.contains("@")) {
                Configuration.remote = remoteUrl;
            } else {
                String login = System.getProperty("remoteBrowserUrlLogin", "user1");
                String password = System.getProperty("remoteBrowserUrlPassword", "1234");
                String host = remoteUrl.replaceAll("^https?://", "");
                Configuration.remote = "https://" + login + ":" + password + "@" + host;
            }

        } else {
            Configuration.remote = null;

        }
    }
}
