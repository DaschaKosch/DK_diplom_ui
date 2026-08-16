package tests.utils;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import tests.config.WebConfig;

public class SelenideSetup {

    public static void applyConfig() {
        // 1. Если env не передан, по умолчанию считаем, что это local
        String env = System.getProperty("env", "local");

        // 2. Создаем конфиг. Благодаря MERGE он объединит local.properties и ${env}.properties
        WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());

        // 3. Применяем настройки к Selenide
        Configuration.browser = config.getBrowser();

        // Если версия пустая, Selenide скачает последнюю доступную
        if (config.getBrowserVersion() != null && !config.getBrowserVersion().isEmpty()) {
            Configuration.browserVersion = config.getBrowserVersion();
        }

        Configuration.browserSize = config.getBrowserSize();
        Configuration.baseUrl = config.getBaseUrl();
        Configuration.headless = true; // Можно тоже вынести в конфиг, если нужно

        // 4. Логика Remote: если remoteUrl есть, подключаемся к нему. Если нет - null (локальный запуск)
        String remoteUrl = config.getRemoteUrl();
        Configuration.remote = (remoteUrl != null && !remoteUrl.isEmpty()) ? remoteUrl : null;

        System.out.println("\n=========================================");
        System.out.println("🚀 ЗАПУСК ТЕСТА (env = " + env + ")");
        System.out.println("🌐 Браузер: " + Configuration.browser);
        System.out.println("🔗 Remote URL: " + (Configuration.remote == null ? "LOCAL (null)" : Configuration.remote));
        System.out.println("=========================================\n");

    }
}
