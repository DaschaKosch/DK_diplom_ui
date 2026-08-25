package tests;


import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import pages.CartPage;
import pages.CatalogPage;
import pages.MainPage;
import pages.ProductPage;
import pages.components.CookieBannerComponent;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import config.SelenideSetup;


public class TestBase {
    protected MainPage mainPage;
    protected CartPage cartPage;
    protected CatalogPage catalogPage;
    protected ProductPage productPage;

    @BeforeAll
    static void setupAll() {
        SelenideSetup.applyConfig();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true));
    }

    @BeforeEach
    void setUp() {

        mainPage = new MainPage();
        cartPage = new CartPage();
        catalogPage = new CatalogPage();
        productPage = new ProductPage();

        new CookieBannerComponent().closeIfPresent();

    }

    @AfterEach
    void tearDown() {
        try {
            if (WebDriverRunner.hasWebDriverStarted()) {
                Attach.screenshotAs("Last screenshot");
                Attach.pageSource();
                Attach.browserConsoleLogs();
                Attach.addVideo();
            }
        } finally {
            closeWebDriver();
        }
    }
}

