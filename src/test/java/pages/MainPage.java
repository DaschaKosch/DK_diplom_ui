package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import java.time.Duration;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static testdata.TestData.WOMEN_CATALOG;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {


    private final SelenideElement logo = $(byAttribute("data-testid", "header-logo"));
    private final SelenideElement womenMenu = $(byAttribute("data-testid", "gender-link-female"));
    private final SelenideElement menMenu = $(byAttribute("data-testid", "gender-link-male"));
    private final SelenideElement cartIcon = $(byAttribute("data-testid", "header-cart-link"));
    private final SelenideElement cookieButton = $("[data-bui-id='Button'], button:contains('ок'), .cookie-accept, [class*='cookie'] button");
    private final SelenideElement searchInput = $(".digi-search-form__input");


    @Step("Открыть главную страницу Befree")
    public MainPage openPage() {
        open("/");
        return this;
    }

    @Step("Закрыть cookie-баннер, если он отображается")
    public MainPage acceptCookies() {
        try {
            cookieButton.shouldBe(visible, Duration.ofSeconds(5)).click();
        } catch (Throwable ignored) {
        }
        return this;
    }

    @Step("Проверить корректность отображения хэдера")
    public MainPage verifyHeaderIsCorrect() {
        logo.shouldBe(visible);
        womenMenu.shouldBe(visible);
        menMenu.shouldBe(visible);
        cartIcon.shouldBe(visible);
        return this;
    }

    @Step("Перейти в раздел 'Женское'")
    public CatalogPage goToWomenSection() {
        com.codeborne.selenide.Selenide.open(WOMEN_CATALOG);
        return page(CatalogPage.class);
    }


    @Step("Выполнить поиск: {query}")
    public CatalogPage searchFor(String query) {
        com.codeborne.selenide.Selenide.executeJavaScript(
                "arguments[0].value = arguments[1]; arguments[0].dispatchEvent(new Event('input', {bubbles: true}));",
                searchInput, query
        );
        com.codeborne.selenide.Selenide.executeJavaScript(
                "arguments[0].click();",
                $(".digi-search-form__submit")
        );
        return page(CatalogPage.class);
    }

    @Step("Открыть корзину из хэдера")
    public CartPage openCart() {
        cartIcon.shouldBe(com.codeborne.selenide.Condition.visible).click();
        com.codeborne.selenide.Selenide.Wait().until(
                driver -> driver.getCurrentUrl().toLowerCase().contains("/cart")
        );

        return page(CartPage.class);
    }
}

